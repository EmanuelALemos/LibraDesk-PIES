package command;

import controller.EditarLeitorController;
import controller.Main;
import screens.view.AcervoView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;
import screens.view.EditarLeitorView;

public class EditarLeitorCommand implements PopUpCommand {
    
    
    public void execute(IModel leitor) throws Exception {
        
        
        
        // Carregando o arquivo FXML da tela de edição
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../screens/fxml/EditarLeitor.fxml"));
            Parent root = loader.load();
            root.getStylesheets().add(getClass().getResource("../screens/css/style.css").toExternalForm());



            // Obtendo o controlador da tela de edição
            EditarLeitorView controller = loader.getController();

            // Passando o LeitorModel selecionado para o controlador
            controller.preencherCampos((LeitorModel) leitor);

            // Criando um novo palco (Stage) para a tela de edição
            Stage edicaoLeitorStage = new Stage();
            edicaoLeitorStage.setTitle("Editar Leitor");
            edicaoLeitorStage.initStyle(StageStyle.UTILITY);
            edicaoLeitorStage.initModality(Modality.APPLICATION_MODAL);
            edicaoLeitorStage.setScene(new Scene(root, 992, 614));

            // Exibindo o palco
            edicaoLeitorStage.showAndWait();
    }

   
}
