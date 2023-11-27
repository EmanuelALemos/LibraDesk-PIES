/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.util.*;
import java.sql.*;
import conexaoDAO.Conexao;
import java.net.URL;
import java.sql.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;
import javafx.scene.control.TextField;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.LivroModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author CAIO
 */
public class AcervoController{
    
    
    @FXML 
    private TextField txtTituloPesquisado;
    
    @FXML
    protected void btNovoLivro(ActionEvent e){
        // Main.changeScreen("novoLivro");
        openNovoLivroPopup();
    }

     @FXML
    protected void btLeitores(ActionEvent e){
        Main.changeScreen("leitores");
    }

    @FXML
    protected void btEmprestimos(ActionEvent e){
        Main.changeScreen("emprestimos");
    }

    @FXML
    protected void btEmAtraso(ActionEvent e){
        Main.changeScreen("em_atraso");
    }

    private static void openNovoLivroPopup() {
        try {
            // Carregando o arquivo FXML da tela NovoLivro
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/NovoLivro.fxml"));
            Parent root = loader.load();

            // Criando um novo palco (Stage) para a tela NovoLivro
            Stage novoLivroStage = new Stage();
            novoLivroStage.setTitle("Novo Livro");
            novoLivroStage.initStyle(StageStyle.UTILITY);
            novoLivroStage.initModality(Modality.APPLICATION_MODAL);
            novoLivroStage.setScene(new Scene(root, 992, 614));

            // Exibindo o palco
            novoLivroStage.showAndWait();
        } catch (Exception e) {
            // Tratamento de exceção (substitua por um tratamento adequado)
            e.printStackTrace();
        }
    }
    
    @FXML
    private TableView<LivroModel> livrosTableView;

    
    List<LivroModel> livros;
    
    @FXML
    protected void btBuscarLivrosPorTitulo(ActionEvent event) {
        
        String titulo = txtTituloPesquisado.getText(); // Suponha que você tenha um campo de texto para digitar o título.
        livros = pesquisarLivroPorTitulo(titulo);
        preencherTableView(livros);
    }
    
    
    @FXML
    public void initialize() {
        TableColumn<LivroModel, String> colTitulo = new TableColumn("Titulo");
        colTitulo.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getTitulo()));
        
        TableColumn<LivroModel, String> colAutor = new TableColumn("Autor");
        colAutor.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getAutor()));
        
        TableColumn<LivroModel, String> colLocalizacao = new TableColumn("Localizacao");
        colLocalizacao.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getLocalBiblioteca()));
        
        TableColumn<LivroModel,Integer> colNumExemplares = new TableColumn("Numero Exemplares");
        colNumExemplares.setCellValueFactory(data-> new SimpleIntegerProperty(data.getValue().getNumeroExemplares()).asObject() );
        
        TableColumn<LivroModel,Integer> colId = new TableColumn("Id");
        colId.setCellValueFactory(data-> new SimpleIntegerProperty(data.getValue().getId()).asObject() );
        
        livrosTableView.getColumns().addAll(colId, colTitulo, colAutor, colLocalizacao, colNumExemplares);
        
        atualizarTabela();
    }
    
    public void atualizarTabela(){
        List<LivroModel> acervo = pegarLivrosAcervo();
        preencherTableView(acervo);
    }
    
    public List<LivroModel> pegarLivrosAcervo(){
        //JOptionPane.showMessageDialog(null, " OK! ");
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();
        List<LivroModel> listaLivros = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM Livro";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LivroModel livro = new LivroModel();
                livro.setId(resultSet.getInt("id"));
                livro.setTitulo(resultSet.getString("titulo"));
                livro.setAutor(resultSet.getString("autor"));
                livro.setLocalBiblioteca(resultSet.getString("local_biblioteca"));
                livro.setNumeroExemplares(resultSet.getInt("num_exemplares"));
                listaLivros.add(livro);
            }
        }catch (SQLException exececaoAcervo){
             exececaoAcervo.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + exececaoAcervo.getMessage());
        }
        
        return listaLivros;
    }
    

    
    public void preencherTableView(List<LivroModel> livros) {
        ObservableList<LivroModel> livrosObservableList = FXCollections.observableArrayList(livros);
        livrosTableView.setItems(livrosObservableList);
    }   
    
    public List<LivroModel> pesquisarLivroPorTitulo(String titulo){
        //JOptionPane.showMessageDialog(null, " OK! ");
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();
        List<LivroModel> listaLivros = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM Livro WHERE titulo LIKE ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, "%" + titulo + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LivroModel livro = new LivroModel();
                livro.setId(resultSet.getInt("id"));
                livro.setTitulo(resultSet.getString("titulo"));
                livro.setAutor(resultSet.getString("autor"));
                livro.setLocalBiblioteca(resultSet.getString("local_biblioteca"));
                livro.setNumeroExemplares(resultSet.getInt("num_exemplares"));
                listaLivros.add(livro);
            }
        }catch (SQLException exececaoAcervo){
             exececaoAcervo.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + exececaoAcervo.getMessage());
        }
        
        return listaLivros;
    }
    
    @FXML
    public void btOpenEditarLivro(){
        LivroModel livroSelecionado = livrosTableView.getSelectionModel().getSelectedItem();
        
        try {
            // Carregando o arquivo FXML da tela de edição
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/EditarLivro.fxml"));
            Parent root = loader.load();

            // Obtendo o controlador da tela de edição
            EditarLivroController controller = loader.getController();

            // Passando o LeitorModel selecionado para o controlador
            controller.preencherCampos(livroSelecionado);
            controller.setAcervoController(this);

            // Criando um novo palco (Stage) para a tela de edição
            Stage edicaoLeitorStage = new Stage();
            edicaoLeitorStage.setTitle("Editar Livro");
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
    
    @FXML
    public void BtExcluirLivro(ActionEvent e){
        LivroModel livroSelecionado = livrosTableView.getSelectionModel().getSelectedItem();
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();
        
        try{
            String sql = "DELETE FROM Livro WHERE id = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, livroSelecionado.getId());
            
            preparedStatement.executeUpdate();
            atualizarTabela();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    
    }

    protected void btPerfil(ActionEvent e){
        Main.changeScreen("perfil");
    }
    
    
}
