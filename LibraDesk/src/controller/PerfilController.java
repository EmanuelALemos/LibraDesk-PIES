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
 * @author arauj
 */
public class PerfilController{
    
    @FXML
    protected void btAcervo(ActionEvent e){
        Main.changeScreen("acervo");
    }

     @FXML
    protected void btLogout(ActionEvent e){
        Main.changeScreen("login");
    }

     @FXML
    protected void btExcluir(ActionEvent e){
        openExcluirPopup();
    }

     @FXML
    protected void btEditar(ActionEvent e){
        openEditarPopup();
    }

    private static void openExcluirPopup() {
        try {
            // Carregando o arquivo FXML da tela NovoLivro
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/ConfirmarExcluir.fxml"));
            Parent root = loader.load();

            // Criando um novo palco (Stage) para a tela NovoLivro
            Stage novoLeitorStage = new Stage();
            novoLeitorStage.setTitle("Confrimar Exclusão");
            novoLeitorStage.initStyle(StageStyle.UTILITY);
            novoLeitorStage.initModality(Modality.APPLICATION_MODAL);
            novoLeitorStage.setScene(new Scene(root, 530, 200));

            // Exibindo o palco
            novoLeitorStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


     private static void openEditarPopup() {
        try {
            // Carregando o arquivo FXML da tela NovoLivro
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/EditarPerfil.fxml"));
            Parent root = loader.load();

            // Criando um novo palco (Stage) para a tela NovoLivro
            Stage novoLeitorStage = new Stage();
            novoLeitorStage.setTitle("Editar Perfil");
            novoLeitorStage.initStyle(StageStyle.UTILITY);
            novoLeitorStage.initModality(Modality.APPLICATION_MODAL);
            novoLeitorStage.setScene(new Scene(root, 992, 614));

            // Exibindo o palco
            novoLeitorStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
