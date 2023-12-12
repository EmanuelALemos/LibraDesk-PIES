package command;

import controller.Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NovoLivroCommand implements Command {
    public void execute() throws Exception {
        
        
        Parent xmlNovoLivro = FXMLLoader.load(getClass().getResource("../screens/fxml/NovoLivro.fxml"));
        // Criando um novo palco (Stage) para a tela NovoLivro
        Scene novoLivro = new Scene(xmlNovoLivro, 992, 614);
        novoLivro.getStylesheets().add(getClass().getResource("../screens/css/style.css").toExternalForm());

        Stage novoLivroStage = new Stage();
        novoLivroStage.setTitle("Novo Livro");
        novoLivroStage.initStyle(StageStyle.UTILITY);
        novoLivroStage.initModality(Modality.APPLICATION_MODAL);
        novoLivroStage.setScene(novoLivro);
        System.out.println("CHEGOU");
        novoLivroStage.showAndWait();
        
    }

}
