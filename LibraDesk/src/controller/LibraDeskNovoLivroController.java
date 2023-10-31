/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import conexaoDAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author arauj
 */
public class LibraDeskNovoLivroController{

 // A conexão com o banco de dados
    
    @FXML
    private TextField tituloLivro;
    @FXML
    private TextField autorLivro;
    @FXML
    private TextField localizacaoLivro;
    @FXML
    private TextField numExemplaresLivro;
    
    
    
    @FXML
    public void BtCadastrar(ActionEvent e){
        
        adicionarLivro();
    }
    
    public void adicionarLivro() {
        
        try {     
            Conexao conSing = Conexao.getInstancy();
            Connection conexao = conSing.getConexao();
            
            String sql = "INSERT INTO Livro (titulo, local_biblioteca, num_exemplares, autor) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, tituloLivro.getText());
            preparedStatement.setString(2, localizacaoLivro.getText());
            preparedStatement.setInt(3, Integer.parseInt(numExemplaresLivro.getText()));
            preparedStatement.setString(4, autorLivro.getText());
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {       
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + e.getMessage());
        }
    }
    
       
    
}
