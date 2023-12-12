package command;

import controller.EditarLivroController;
import controller.IController;
import controller.Main;
import screens.view.AcervoView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.IModel;
import model.LivroModel;
import screens.view.EditarLivroView;

public class EditarLivroCommand implements PopUpCommand {
    
    public void execute(IModel Ilivro) throws Exception {
        
        LivroModel livro = (LivroModel) Ilivro;
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../screens/fxml/EditarLivro.fxml"));
        Parent xmlEditarLivro = fxmlLoader.load();
        EditarLivroView controller = fxmlLoader.getController();
        controller.preencherCampos(livro);

        Scene editarLivro = new Scene(xmlEditarLivro, 992, 614);
        editarLivro.getStylesheets().add(getClass().getResource("../screens/css/style.css").toExternalForm());
        Stage editarLivroStage = new Stage();
        editarLivroStage.setTitle("Novo Livro");
        editarLivroStage.initStyle(StageStyle.UTILITY);
        editarLivroStage.initModality(Modality.APPLICATION_MODAL);
        editarLivroStage.setScene(editarLivro);
        editarLivroStage.showAndWait();
    }
}
