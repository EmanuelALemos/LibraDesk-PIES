/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import conexaoDAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import model.LivroModel;
import model.EmprestimoModel;
import model.LeitorModel;

/**
 * FXML Controller class
 *
 * @author CAIO
 */
public class EmprestimosController {

    @FXML
    protected void btLeitores(ActionEvent e) {
        Main.changeScreen("leitores");
    }

    @FXML
    protected void btAcervo(ActionEvent e) {
        Main.changeScreen("acevo");
    }

    @FXML
    protected void btEmAtraso(ActionEvent e) {
        Main.changeScreen("em_atraso");
    }

    @FXML
    protected void btNovoEmprestimo(ActionEvent e) {
        openNovoEmprestimoPopup();
    }

    @FXML
    private TableView<EmprestimoModel> emprestimosTableView;
    
    @FXML
    private MenuButton btOpcaoBusca;
    
    @FXML
    private TextField txtCampoPesquisado;
    

    private static void openNovoEmprestimoPopup() {
        try {
            // Carregando o arquivo FXML da tela NovoLivro
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/NovoEmprestimo.fxml"));
            Parent root = loader.load();

            // Criando um novo palco (Stage) para a tela NovoLivro
            Stage novoEmprestimoStage = new Stage();
            novoEmprestimoStage.setTitle("Novo Livro");
            novoEmprestimoStage.initStyle(StageStyle.UTILITY);
            novoEmprestimoStage.initModality(Modality.APPLICATION_MODAL);
            novoEmprestimoStage.setScene(new Scene(root, 992, 614));

            // Exibindo o palco
            novoEmprestimoStage.showAndWait();
        } catch (Exception e) {
            // Tratamento de exceção (substitua por um tratamento adequado)
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        
        MenuItem item1 = new MenuItem("Por leitor");
        MenuItem item2 = new MenuItem("Por titulo");
        
        item1.setOnAction(event -> handleOpcaoSelecionada(item1));
        item2.setOnAction(event -> handleOpcaoSelecionada(item2));

        btOpcaoBusca.getItems().addAll(item1, item2);
        
        TableColumn<EmprestimoModel, Integer> colIdEmprestimo = new TableColumn<>("Nº");
        colIdEmprestimo.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getIdEmprestimo()).asObject());
        
        TableColumn<EmprestimoModel, String> colNomeLeitor = new TableColumn<>("Nome Leitor");
        colNomeLeitor.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNomeLeitor()));

        TableColumn<EmprestimoModel, String> colCpfLeitor = new TableColumn<>("CPF Leitor");
        colCpfLeitor.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCpfLeitor()));

        TableColumn<EmprestimoModel, String> colNomeLivro = new TableColumn<>("Nome Livro");
        colNomeLivro.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNomeLivro()));

        TableColumn<EmprestimoModel, Date> colDataEmprestimo = new TableColumn<>("Data Empréstimo");
        colDataEmprestimo.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDataEmprestimo()));

        TableColumn<EmprestimoModel, Date> colDataPrevDevolucao = new TableColumn<>("Data Devolução Prevista");
        colDataPrevDevolucao.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDataPrevDev()));

        TableColumn<EmprestimoModel, Double> colMulta = new TableColumn<>("Multa");
        colMulta.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getMulta()));

        TableColumn<EmprestimoModel, String> colStatus = new TableColumn<>("Status");
        colStatus.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStatus()));
        
        emprestimosTableView.getColumns().addAll(colIdEmprestimo,colNomeLeitor, colCpfLeitor, colNomeLivro, colDataEmprestimo, colDataPrevDevolucao, colMulta, colStatus);
        atualizarTabela();

    }
    
    public void atualizarTabela(){
        List<EmprestimoModel> emprestimos = pegarEmprestimos();
        preencherTableViewEmprestimo(emprestimos);
    
    }
    
    private String getOpcaoBusca(){
        return btOpcaoBusca.getText();
    }
    
    @FXML
    protected void btBuscarEmprestimo(ActionEvent action){
        
        
        
            if(getOpcaoBusca() == "Por leitor"){
                List<EmprestimoModel> emprestimos = buscarEmprestimoPorLeitor(txtCampoPesquisado.getText());
                preencherTableViewEmprestimo(emprestimos);
            }else if(getOpcaoBusca() == "Por titulo"){
                List<EmprestimoModel> emprestimos = buscarEmprestimoPorLivro(txtCampoPesquisado.getText());
                preencherTableViewEmprestimo(emprestimos);
            }else{
                JOptionPane.showMessageDialog(null, "selecione uma forma de pesquisa desejado");
            }
            
        
    
    }
    
    public List<EmprestimoModel> buscarEmprestimoPorLeitor(String nomeLeitor){
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();
        
        List<EmprestimoModel> listaEmprestimo = new ArrayList<>();
        
        try{
            
            String sql = "SELECT * FROM emprestimo e JOIN pessoa p ON e.cpf_leitor = p.cpf JOIN livro l ON l.id = e.id_livro WHERE (p.pnome || ' ' || p.sobrenome) LIKE ? AND "
                    + "e.status = true ";           
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, "%" + nomeLeitor + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                EmprestimoModel emprestimo = new EmprestimoModel(
                        resultSet.getString("pnome") + " " + resultSet.getString("sobrenome"),
                        resultSet.getDate("data_emprestimo"),
                        resultSet.getDate("data_prev_dev"),
                        resultSet.getDate("data_real_dev"),
                        resultSet.getDouble("multa"),
                        resultSet.getString("cpf_leitor"),
                        resultSet.getString("titulo"),
                        resultSet.getInt("id_livro"),
                        resultSet.getBoolean("status"),
                        resultSet.getInt("id_emprestimo")
                );
            
                listaEmprestimo.add(emprestimo);
            }
            
        } catch (SQLException excecaoLeitor) {
            excecaoLeitor.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + excecaoLeitor.getMessage());
        }
        
        return listaEmprestimo;
    }
    
    public List<EmprestimoModel> buscarEmprestimoPorLivro(String tituloLivro){
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();
        
        List<EmprestimoModel> listaEmprestimo = new ArrayList<>();
        
        try{
            
            String sql = "SELECT * FROM emprestimo e JOIN pessoa p ON e.cpf_leitor = p.cpf JOIN livro l ON l.id = e.id_livro WHERE l.titulo LIKE ? AND e.status = true";           
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, "%" + tituloLivro + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                EmprestimoModel emprestimo = new EmprestimoModel(
                        resultSet.getString("pnome") + " " + resultSet.getString("sobrenome"),
                        resultSet.getDate("data_emprestimo"),
                        resultSet.getDate("data_prev_dev"),
                        resultSet.getDate("data_real_dev"),
                        resultSet.getDouble("multa"),
                        resultSet.getString("cpf_leitor"),
                        resultSet.getString("titulo"),
                        resultSet.getInt("id_livro"),
                        resultSet.getBoolean("status"),
                        resultSet.getInt("id_emprestimo")
                );
                
            
                listaEmprestimo.add(emprestimo);
            }
            
        } catch (SQLException excecaoLeitor) {
            excecaoLeitor.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + excecaoLeitor.getMessage());
        }
        
        return listaEmprestimo;
    }

    public void calcularMulta(int idEmprestimo){
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();
        LocalDate dataAtual = LocalDate.now();


        try{
            
            String sql = "SELECT * FROM emprestimo WHERE id_emprestimo = ?";           
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, idEmprestimo);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Date dataPrevDevolucao = resultSet.getDate("data_prev_dev");
                LocalDate dataPrevDevolucaoLocalDate = new java.sql.Date(dataPrevDevolucao.getTime()).toLocalDate();
                
                
                long diferencaEmDias = calcularDiferencaDias(dataPrevDevolucaoLocalDate, dataAtual);
                double multa = diferencaEmDias * 0.50;
                
                if(multa < 0){
                    multa = 0;
                }

                String sql2 = "UPDATE emprestimo SET multa = ? WHERE id_emprestimo = ?";
                PreparedStatement preparedStatement2 = conexao.prepareStatement(sql2);
                preparedStatement2.setDouble(1, multa);
                preparedStatement2.setInt(2, idEmprestimo);
                preparedStatement2.executeUpdate();
            }
            
        } catch (SQLException excecaoLeitor) {
            excecaoLeitor.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado 2 " + excecaoLeitor.getMessage());
        }
        

    }

    public static long calcularDiferencaDias(LocalDate data1, LocalDate data2) {
        // Calcula a diferença em dias usando ChronoUnit
        return ChronoUnit.DAYS.between(data1, data2);
    }
    
    public List<EmprestimoModel> pegarEmprestimos(){
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();
        
        List<EmprestimoModel> listaEmprestimo = new ArrayList<>();
        
        try{
            
            String sql = "SELECT * FROM emprestimo e JOIN pessoa p ON e.cpf_leitor = p.cpf JOIN livro l ON l.id = e.id_livro WHERE e.status = true";           
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                calcularMulta(resultSet.getInt("id_emprestimo"));
                
                EmprestimoModel emprestimo = new EmprestimoModel(
                        resultSet.getString("pnome") + " " + resultSet.getString("sobrenome"),
                        resultSet.getDate("data_emprestimo"),
                        resultSet.getDate("data_prev_dev"),
                        resultSet.getDate("data_real_dev"),
                        resultSet.getDouble("multa"),
                        resultSet.getString("cpf_leitor"),
                        resultSet.getString("titulo"),
                        resultSet.getInt("id_livro"),
                        resultSet.getBoolean("status"),
                        resultSet.getInt("id_emprestimo")
                );
                
            
                listaEmprestimo.add(emprestimo);
            }
            
        } catch (SQLException excecaoLeitor) {
            excecaoLeitor.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado 3 " + excecaoLeitor.getMessage());
        }
        
        return listaEmprestimo;
    }
    
    
    
    public void preencherTableViewEmprestimo(List<EmprestimoModel> emprestimos) {
        ObservableList<EmprestimoModel> emprestimosObservableList = FXCollections.observableArrayList(emprestimos);
        emprestimosTableView.setItems(emprestimosObservableList);
    }
    
    
    private void handleOpcaoSelecionada(MenuItem menuItem) {
        // Atualiza o texto do MenuButton com o texto do item selecionado
        btOpcaoBusca.setText(menuItem.getText());
        
    }
    
    @FXML
    protected void btDebitarEmprestimo(ActionEvent e){
        EmprestimoModel emprestimoSelecionado = emprestimosTableView.getSelectionModel().getSelectedItem();
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();
        
        try{
            String sql = "UPDATE Emprestimo SET status = false WHERE id_emprestimo = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, emprestimoSelecionado.getIdEmprestimo());
            preparedStatement.executeUpdate();
            atualizarTabela();
        
        } catch (SQLException excecaoLeitor) {
            excecaoLeitor.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado 4 " + excecaoLeitor.getMessage());
        }
    }
    
    

}
