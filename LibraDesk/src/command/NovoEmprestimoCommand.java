package command;

import controller.Main;
import controller.NovoEmprestimoController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NovoEmprestimoCommand implements Command{
    public void execute() throws Exception {
         // Carregando o arquivo FXML da tela NovoLivro
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../screens/fxml/NovoEmprestimo.fxml"));
            Parent root = loader.load();
            root.getStylesheets().add(getClass().getResource("../screens/css/style.css").toExternalForm());

            // Criando um novo palco (Stage) para a tela NovoLivro
            Stage novoEmprestimoStage = new Stage();
            novoEmprestimoStage.setTitle("Novo Emprestimo");
            novoEmprestimoStage.initStyle(StageStyle.UTILITY);
            novoEmprestimoStage.initModality(Modality.APPLICATION_MODAL);
            novoEmprestimoStage.setScene(new Scene(root, 992, 614));

            // Exibindo o palco
            novoEmprestimoStage.showAndWait();   
    }
}
