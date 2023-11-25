/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import javafx.collections.ObservableList;
import conexaoDAO.Conexao;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.LeitorModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author CAIO
 */
public class LeitoresController{
    
    @FXML
    private TextField txtLeitorPesquisado;
    
    @FXML
    private TableView<LeitorModel> leitoresTableView;
    
    @FXML
    protected void btAcervo(ActionEvent e){
        Main.changeScreen("acervo");
    }

    @FXML
    protected void btEmprestimos(ActionEvent e){
        Main.changeScreen("emprestimos");
    }

    @FXML
    protected void btEmAtraso(ActionEvent e){
        Main.changeScreen("em_atraso");
    }

    @FXML
    protected void btNovoLeitor(ActionEvent e){
        openNovoLeitorPopup();
    }
    
    @FXML
    protected void btEditarLeitor(ActionEvent e){
        LeitorModel leitorSelecionado = leitoresTableView.getSelectionModel().getSelectedItem();

        try {
            // Carregando o arquivo FXML da tela de edição
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/EditarLeitor.fxml"));
            Parent root = loader.load();

            // Obtendo o controlador da tela de edição
            EditarLeitorController controller = loader.getController();

            // Passando o LeitorModel selecionado para o controlador
            controller.preencherCampos(leitorSelecionado);
            controller.setLeitoresController(this);

            // Criando um novo palco (Stage) para a tela de edição
            Stage edicaoLeitorStage = new Stage();
            edicaoLeitorStage.setTitle("Editar Leitor");
            edicaoLeitorStage.initStyle(StageStyle.UTILITY);
            edicaoLeitorStage.initModality(Modality.APPLICATION_MODAL);
            edicaoLeitorStage.setScene(new Scene(root, 992, 614));

            // Exibindo o palco
            edicaoLeitorStage.showAndWait();
        } catch (Exception ex) {
            // Tratamento de exceção (substitua por um tratamento adequado)
            ex.printStackTrace();
        }
    }

    private static void openNovoLeitorPopup() {
        try {
            // Carregando o arquivo FXML da tela NovoLivro
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/NovoLeitor.fxml"));
            Parent root = loader.load();

            // Criando um novo palco (Stage) para a tela NovoLivro
            Stage novoLeitorStage = new Stage();
            novoLeitorStage.setTitle("Novo Leitor");
            novoLeitorStage.initStyle(StageStyle.UTILITY);
            novoLeitorStage.initModality(Modality.APPLICATION_MODAL);
            novoLeitorStage.setScene(new Scene(root, 992, 614));

            // Exibindo o palco
            novoLeitorStage.showAndWait();
        } catch (Exception e) {
            // Tratamento de exceção (substitua por um tratamento adequado)
            e.printStackTrace();
        }
    }
    
    @FXML
    public void initialize() {
        // Coluna para Nome Completo usando getNomeCompleto
        TableColumn<LeitorModel, String> colNomeCompleto = new TableColumn<>("Nome Completo");
        colNomeCompleto.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().getNomeCompleto())
        );

        // Coluna para CPF
        TableColumn<LeitorModel, String> colCpf = new TableColumn<>("CPF");
        colCpf.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().getCpf())
        );

        // Coluna para Telefone Um
        TableColumn<LeitorModel, String> colTelefoneUm = new TableColumn<>("Telefone Um");
        colTelefoneUm.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().getTelefoneUm())
        );

        // Coluna para Telefone Dois
        TableColumn<LeitorModel, String> colTelefoneDois = new TableColumn<>("Telefone Dois");
        colTelefoneDois.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().getTelefoneDois())
        );

        // Coluna para Número
        TableColumn<LeitorModel, Integer> colNumero = new TableColumn<>("Número");
        colNumero.setCellValueFactory(data -> new SimpleIntegerProperty(
                data.getValue().getNumero()).asObject()
        );

        // Coluna para Endereço usando getEndereco
        TableColumn<LeitorModel, String> colEndereco = new TableColumn<>("Endereço");
        colEndereco.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().getEndereco())
        );

        // Adicionando as colunas à TableView
        leitoresTableView.getColumns().addAll(colNomeCompleto, colCpf, colTelefoneUm, colTelefoneDois,colEndereco, colNumero);

        // Obtendo a lista de leitores e preenchendo a TableView
        atualizarTabela();
    }
    
    public void atualizarTabela(){
        List<LeitorModel> leitores = pegarLeitores(); 
        preencherTableViewLeitor(leitores);
    }
    
    public List<LeitorModel> pegarLeitores(){
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();
        List<LeitorModel> listaLeitores = new ArrayList<>();
        
        try {
        String sql = "SELECT * FROM Leitor";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        ResultSet resultSetLeitor = preparedStatement.executeQuery();
        
        String sqlPessoa = "SELECT * FROM Pessoa";
        PreparedStatement preparedStatementPessoa = conexao.prepareStatement(sqlPessoa);
        ResultSet resultSetPessoa = preparedStatementPessoa.executeQuery();

            while (resultSetLeitor.next() && resultSetPessoa.next()) {
                LeitorModel leitor = new LeitorModel(
                    resultSetPessoa.getString("pnome"),
                    resultSetPessoa.getString("sobrenome"),
                    resultSetPessoa.getString("cpf"),
                    resultSetLeitor.getString("telefone_um"),
                    resultSetLeitor.getString("telefone_dois"),
                    resultSetLeitor.getString("bairro"),
                    resultSetLeitor.getString("rua"),
                    resultSetLeitor.getString("cidade"),
                    resultSetLeitor.getInt("numero")
                );
                listaLeitores.add(leitor);
                //JOptionPane.showMessageDialog(null, "cpf: " + leitor.getCidade());
            }
        } catch (SQLException excecaoLeitor) {
            excecaoLeitor.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + excecaoLeitor.getMessage());
        }
        
        return listaLeitores;
    }

    
    @FXML
    protected void btBuscarLeitorPorNome(ActionEvent event){
        String nome = txtLeitorPesquisado.getText();
        List<LeitorModel> leitores = pesquisarLeitorPorNome(nome);
        preencherTableViewLeitor(leitores);
    }
    
    public void preencherTableViewLeitor(List<LeitorModel> leitores) {
        ObservableList<LeitorModel> leitoresObservableList = FXCollections.observableArrayList(leitores);
        leitoresTableView.setItems(leitoresObservableList);
    }
    
    public List<LeitorModel> pesquisarLeitorPorNome(String nomeLeitor) {
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();
        List<LeitorModel> listaLeitores = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Leitor l JOIN pessoa p ON l.cpf = p.cpf WHERE (p.pnome || ' ' || p.sobrenome) LIKE ? ";

            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, "%" + nomeLeitor + "%");
            ResultSet resultSetLeitor = preparedStatement.executeQuery();

            while (resultSetLeitor.next()) {
                LeitorModel leitor = new LeitorModel(
                    resultSetLeitor.getString("pnome"),
                    resultSetLeitor.getString("sobrenome"),
                    resultSetLeitor.getString("cpf"),
                    resultSetLeitor.getString("telefone_um"),
                    resultSetLeitor.getString("telefone_dois"),
                    resultSetLeitor.getString("bairro"),
                    resultSetLeitor.getString("rua"),
                    resultSetLeitor.getString("cidade"),
                    resultSetLeitor.getInt("numero")
                );
                listaLeitores.add(leitor);
            }
        } catch (SQLException excecaoLeitor) {
            excecaoLeitor.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + excecaoLeitor.getMessage());
        }

        return listaLeitores;
    }

    @FXML
    public void btExcluirLeitor(ActionEvent e){
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();
        LeitorModel leitorSelecionado = leitoresTableView.getSelectionModel().getSelectedItem();
        
        
        try{
            String sql = "DELETE FROM Leitor WHERE cpf = ?";            
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, leitorSelecionado.getCpf());          
            preparedStatement.executeUpdate();
            atualizarTabela();
                    
        }catch (SQLException excecaoLeitor) {
            excecaoLeitor.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + excecaoLeitor.getMessage());
        }
    }
    
    
    
    
}
