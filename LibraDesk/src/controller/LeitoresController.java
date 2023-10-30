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
public class LeitoresController{
    
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
    
}
