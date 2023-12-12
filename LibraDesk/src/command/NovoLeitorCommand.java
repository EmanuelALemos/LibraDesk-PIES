package command;

import controller.Main;
import controller.NovoLeitorController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NovoLeitorCommand implements Command
{
    public void execute() throws Exception{
            // Carregando o arquivo FXML da tela NovoLivro
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../screens/fxml/NovoLeitor.fxml"));
            Parent root = loader.load();
            root.getStylesheets().add(getClass().getResource("../screens/css/style.css").toExternalForm());

            // Passando o LeitorModel selecionado para o controlador

            // Criando um novo palco (Stage) para a tela NovoLivro
            Stage novoLeitorStage = new Stage();
            novoLeitorStage.setTitle("Novo Leitor");
            novoLeitorStage.initStyle(StageStyle.UTILITY);
            novoLeitorStage.initModality(Modality.APPLICATION_MODAL);
            novoLeitorStage.setScene(new Scene(root, 992, 614));

            // Exibindo o palco
            novoLeitorStage.showAndWait();
    }
}
