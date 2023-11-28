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
        openConfrimarPopup();
    }


    private void openConfrimarPopup() {
        try {
            // Carregando o arquivo FXML da tela NovoLivro
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/ConfirmarExcluir.fxml"));
            Parent root = loader.load();

            ConfirmarExcluirController controller = loader.getController();
            controller.setAcervoController(this);
            // Criando um novo palco (Stage) para a tela NovoLivro
            Stage confirmarStage = new Stage();
            confirmarStage.setTitle("Confirmar Cadastro");
            confirmarStage.initStyle(StageStyle.UTILITY);
            confirmarStage.initModality(Modality.APPLICATION_MODAL);
            confirmarStage.setScene(new Scene(root, 480, 360));

            // Exibindo o palco
            confirmarStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
