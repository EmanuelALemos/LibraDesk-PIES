/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author CAIO
 */
public class CadastrarUsuarioController{
    
    @FXML
    protected void btVoltar(ActionEvent e){
        Main.changeScreen("login");
    }
    
    @FXML
    protected void btCadastrar(ActionEvent e){
        Main.changeScreen("login");
    }
}
