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
import model.LivroModel;

/**
 * FXML Controller class
 *
 * @author arauj
 */
public class NovoLivroController {


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
        //public LivroModel(String titulo, int id, String localBiblioteca, int numeroExemplares, String autor)
        LivroModel livro = new LivroModel(tituloLivro.getText(), 0, localizacaoLivro.getText(), Integer.parseInt(numExemplaresLivro.getText()), autorLivro.getText());
        adicionarLivro(livro);
        Main.changeScreen("acervo");
    }

    public void btCancelar(ActionEvent e){
        Main.changeScreen("acervo");
    }
    
    public void adicionarLivro(LivroModel livro) {
        
        try {     
            Conexao conSing = Conexao.getInstancy();
            Connection conexao = conSing.getConexao();
            
            String sql = "INSERT INTO Livro (titulo, local_biblioteca, num_exemplares, autor) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.setString(2, livro.getLocalBiblioteca());
            preparedStatement.setInt(3, livro.getNumeroExemplares());
            preparedStatement.setString(4, livro.getAutor());
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {       
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + e.getMessage());
        }
    }
    
       
    
}
