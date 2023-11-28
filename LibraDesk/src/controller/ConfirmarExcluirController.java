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
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.Action;
import javax.swing.JOptionPane;
import model.LivroModel;

/**
 * FXML Controller class
 *
 * @author arauj
 */
public class ConfirmarExcluirController {
    
    public AcervoController acervoController;
    

    public void setAcervoController(AcervoController acervoController) {
        this.acervoController = acervoController;
    }

    @FXML
    protected void btConfirmar(ActionEvent e){
        acervoController.setConfirmacao(true);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void btCancelar(ActionEvent e) {
        acervoController.setConfirmacao(false);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }
}
