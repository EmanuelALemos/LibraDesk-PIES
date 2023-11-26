/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author CAIO
 */
public class EmprestimosController{
    
    @FXML
    protected void btLeitores(ActionEvent e){
        Main.changeScreen("leitores");
    }

    @FXML
    protected void btAcervo(ActionEvent e){
        Main.changeScreen("acevo");
    }

    @FXML
    protected void btEmAtraso(ActionEvent e){
        Main.changeScreen("em_atraso");
    }

    @FXML
    protected void btNovoEmprestimo(ActionEvent e){
        openNovoEmprestimoPopup();
    }

    private static void openNovoEmprestimoPopup() {
        try {
            // Carregando o arquivo FXML da tela NovoLivro
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/NovoEmprestimo.fxml"));
            Parent root = loader.load();

            // Criando um novo palco (Stage) para a tela NovoLivro
            Stage novoEmprestimoStage = new Stage();
            novoEmprestimoStage.setTitle("Novo Livro");
            novoEmprestimoStage.initStyle(StageStyle.UTILITY);
            novoEmprestimoStage.initModality(Modality.APPLICATION_MODAL);
            novoEmprestimoStage.setScene(new Scene(root, 992, 614));

            // Exibindo o palco
            novoEmprestimoStage.showAndWait();
        } catch (Exception e) {
            // Tratamento de exceção (substitua por um tratamento adequado)
            e.printStackTrace();
        }
    }
    
}
