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
import javax.swing.JOptionPane;

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

    @FXML
    protected void btNovoLeitor(ActionEvent e){
        openNovoLeitorPopup();
    }

    private static void openNovoLeitorPopup() {
        try {
            // Carregando o arquivo FXML da tela NovoLivro
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/NovoLeitor.fxml"));
            Parent root = loader.load();

            // Criando um novo palco (Stage) para a tela NovoLivro
            Stage novoLeitorStage = new Stage();
            novoLeitorStage.setTitle("Novo Leitor");
            novoLeitorStage.initStyle(StageStyle.UTILITY);
            novoLeitorStage.initModality(Modality.APPLICATION_MODAL);
            novoLeitorStage.setScene(new Scene(root, 992, 614));

            // Exibindo o palco
            novoLeitorStage.showAndWait();
        } catch (Exception e) {
            // Tratamento de exceção (substitua por um tratamento adequado)
            e.printStackTrace();
        }
    }
    
}
