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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
        Main.changeScreen("novoLivro");
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
    
    @FXML
    private TableView<LivroModel> livrosTableView;

    @FXML
    private TableColumn<LivroModel, String> tituloColuna;
    @FXML
    private TableColumn<LivroModel, String> autorColuna;
    @FXML
    private TableColumn<LivroModel, String> localizacaoColuna;
    @FXML
    private TableColumn<LivroModel, Integer> numExemplaresColuna;
    @FXML
    private TableColumn<LivroModel, Integer> idColuna;
    
    List<LivroModel> livros;
    
    @FXML
    protected void btBuscarLivrosPorTitulo(ActionEvent event) {
        String titulo = txtTituloPesquisado.getText(); // Suponha que você tenha um campo de texto para digitar o título.
        livros = pesquisarLivroPorTitulo(titulo);
        preencherTableView(livros);
    }
    
    
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        /*idColuna.setCellValueFactory(new PropertyValueFactory<>("id"));
        tituloColuna.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        autorColuna.setCellValueFactory(new PropertyValueFactory<>("autor"));
        localizacaoColuna.setCellValueFactory(new PropertyValueFactory<>("localizacao"));
        numExemplaresColuna.setCellValueFactory(new PropertyValueFactory<>("numExemplares"));*/
        updateList();
    }
    
    private void updateList(){
        //livros.getItems().clear();
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
    
    
    
}
