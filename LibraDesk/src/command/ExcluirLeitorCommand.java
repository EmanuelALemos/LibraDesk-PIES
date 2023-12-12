/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import controller.Main;
import model.IModel;
import model.LeitorModel;
import screens.view.ConfirmarExcluirLeitorView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author gabri
 */
public class ExcluirLeitorCommand implements PopUpCommand{
    public void execute(IModel Ileitor) throws Exception{
        // Carregando o arquivo FXML da tela NovoLivro
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../screens/fxml/ConfirmarExcluirLeitor.fxml"));
            Parent root = loader.load();//

            ConfirmarExcluirLeitorView controller = loader.getController();
            LeitorModel leitor = (LeitorModel) Ileitor;
            controller.setCpfLeitor(leitor.getCpf());
            // Criando um novo palco (Stage) para a tela NovoLivro
            Stage excluirStage = new Stage();
            excluirStage.setTitle("Confrimar Exclusão");
            excluirStage.initStyle(StageStyle.UTILITY);
            excluirStage.initModality(Modality.APPLICATION_MODAL);
            excluirStage.setScene(new Scene(root, 530, 200));

            // Exibindo o palco
            excluirStage.showAndWait();
    }
}
