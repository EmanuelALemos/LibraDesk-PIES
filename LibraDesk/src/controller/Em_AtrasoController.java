/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import conexaoDAO.Conexao;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.EmprestimoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

/**
 * FXML Controller class
 *
 * @author CAIO
 */
public class Em_AtrasoController {

    @FXML
    protected void btLeitores(ActionEvent e) {
        Main.changeScreen("leitores");
    }

    @FXML
    protected void btEmprestimos(ActionEvent e) {
        Main.changeScreen("emprestimos");
    }

    @FXML
    protected void btAcervo(ActionEvent e) {
        Main.changeScreen("acervo");
    }

    @FXML
    protected void btPerfil(ActionEvent e){
        Main.changeScreen("perfil");
    }

    @FXML
    protected void btFuncionario(ActionEvent e){
        Main.changeScreen("funcionario");
    }
    
    @FXML
    private TableView<EmprestimoModel> emAtrasoTableView;
    
    @FXML
    private MenuButton btOpcaoBusca;
    
    @FXML
    private TextField txtCampoPesquisado;

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

        emAtrasoTableView.getColumns().addAll(colIdEmprestimo, colNomeLeitor, colCpfLeitor, colNomeLivro, colDataEmprestimo, colDataPrevDevolucao, colMulta, colStatus);
        atualizarTabela();

    }

    public void atualizarTabela() {
        List<EmprestimoModel> emprestimos = pegarEmprestimos();
        preencherTableViewEmprestimo(emprestimos);

    }

    private String getOpcaoBusca() {
        return btOpcaoBusca.getText();
    }

    @FXML
    protected void btBuscarEmprestimo(ActionEvent action) {

        if (getOpcaoBusca() == "Por leitor") {
            List<EmprestimoModel> emprestimos = buscarEmprestimoPorLeitor(txtCampoPesquisado.getText());
            preencherTableViewEmprestimo(emprestimos);
        } else if (getOpcaoBusca() == "Por titulo") {
            List<EmprestimoModel> emprestimos = buscarEmprestimoPorLivro(txtCampoPesquisado.getText());
            preencherTableViewEmprestimo(emprestimos);
        } else {
            JOptionPane.showMessageDialog(null, "selecione uma forma de pesquisa desejado");
        }

    }

    public List<EmprestimoModel> buscarEmprestimoPorLeitor(String nomeLeitor) {
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();

        List<EmprestimoModel> listaEmprestimo = new ArrayList<>();

        try {

            String sql = "SELECT * FROM emprestimo e JOIN pessoa p ON e.cpf_leitor = p.cpf JOIN livro l ON l.id = e.id_livro WHERE (p.pnome || ' ' || p.sobrenome) LIKE ? AND "
                    + "e.status = true e.data_prev_dev < ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            LocalDate dataAtual = LocalDate.now();
            java.sql.Date dataPrevDevolucao = java.sql.Date.valueOf(dataAtual);
            preparedStatement.setDate(2, dataPrevDevolucao);
            preparedStatement.setString(1, "%" + nomeLeitor + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
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

    public List<EmprestimoModel> buscarEmprestimoPorLivro(String tituloLivro) {
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();

        List<EmprestimoModel> listaEmprestimo = new ArrayList<>();

        try {

            String sql = "SELECT * FROM emprestimo e JOIN pessoa p ON e.cpf_leitor = p.cpf JOIN livro l ON l.id = e.id_livro WHERE l.titulo LIKE ? AND e.status = true AND e.data_prev_dev < ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            LocalDate dataAtual = LocalDate.now();
            java.sql.Date dataPrevDevolucao = java.sql.Date.valueOf(dataAtual);
            preparedStatement.setDate(2, dataPrevDevolucao);
            preparedStatement.setString(1, "%" + tituloLivro + "%");
            
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
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

    public List<EmprestimoModel> pegarEmprestimos() {
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();

        List<EmprestimoModel> listaEmprestimo = new ArrayList<>();

        try {

            String sql = "SELECT * FROM emprestimo e JOIN pessoa p ON e.cpf_leitor = p.cpf JOIN livro l ON l.id = e.id_livro WHERE e.status = true AND e.data_prev_dev < ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            LocalDate dataAtual = LocalDate.now();
            java.sql.Date dataPrevDevolucao = java.sql.Date.valueOf(dataAtual);
            preparedStatement.setDate(1, dataPrevDevolucao);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
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
        emAtrasoTableView.setItems(emprestimosObservableList);
    }

    private void handleOpcaoSelecionada(MenuItem menuItem) {
        // Atualiza o texto do MenuButton com o texto do item selecionado
        btOpcaoBusca.setText(menuItem.getText());

    }

    @FXML
    protected void btDebitarEmprestimo(ActionEvent e) {
        EmprestimoModel emprestimoSelecionado = emAtrasoTableView.getSelectionModel().getSelectedItem();
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();

        try {
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
