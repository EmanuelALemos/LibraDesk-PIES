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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import org.w3c.dom.Node;

import model.LivroModel;

/**
 * FXML Controller class
 *
 * @author arauj
 */
public class ConfirmarCadastroController {

    @FXML
    protected void btConfirmar(ActionEvent e){
        
    }

    @FXML
    protected void btCancelar(ActionEvent e){
        
        Main.changeScreen("novoUsuario");
        //Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        //stage.close();
    }
}