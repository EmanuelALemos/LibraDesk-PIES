/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import javafx.scene.Node;

/**
 *
 * @author gabri
 */
public class ConfirmarExcluir2Controller {
    
    LeitoresController leitoresController;
    public void setLeitoresController(LeitoresController leitoresController) {
        this.leitoresController = leitoresController;
    }

    @FXML
    protected void btConfirmar(ActionEvent e){
        leitoresController.setConfirmacao(true);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void btCancelar(ActionEvent e) {
        leitoresController.setConfirmacao(false);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

}
