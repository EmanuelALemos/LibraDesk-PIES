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
public class FuncionarioController{
    
    @FXML
    protected void btVoltar(ActionEvent e){
        Main.changeScreen("acervo");
    }

     @FXML
    protected void btExcluir(ActionEvent e){
        openExcluirPopup();
    }
    
    @FXML
    protected void btPerfil(ActionEvent e){
        Main.changeScreen("perfil");
    }
    
    @FXML
    protected void btConfirmarEdicao(ActionEvent e){
        openEditarPopup();
    }

    private static void openExcluirPopup() {
        try {
            // Carregando o arquivo FXML da tela NovoLivro
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/ConfirmarExcluir.fxml"));
            Parent root = loader.load();

            // Criando um novo palco (Stage) para a tela NovoLivro
            Stage excluirStage = new Stage();
            excluirStage.setTitle("Confrimar Exclusão");
            excluirStage.initStyle(StageStyle.UTILITY);
            excluirStage.initModality(Modality.APPLICATION_MODAL);
            excluirStage.setScene(new Scene(root, 530, 200));

            // Exibindo o palco
            excluirStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


     private static void openEditarPopup() {
        try {
            // Carregando o arquivo FXML da tela NovoLivro
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/EditarFuncionario.fxml"));
            Parent root = loader.load();

            // Criando um novo palco (Stage) para a tela NovoLivro
            Stage editarFuncionarioStage = new Stage();
            editarFuncionarioStage.setTitle("Editar Funcionario");
            editarFuncionarioStage.initStyle(StageStyle.UTILITY);
            editarFuncionarioStage.initModality(Modality.APPLICATION_MODAL);
            editarFuncionarioStage.setScene(new Scene(root, 992, 614));

            // Exibindo o palco
            editarFuncionarioStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
