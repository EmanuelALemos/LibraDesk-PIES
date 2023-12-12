package command;

import controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.IModel;
import model.LivroModel;
import screens.view.ConfirmarExcluirLivroView;

public class ExcluirLivroCommand implements PopUpCommand{
    public void execute(IModel Ilivro) throws Exception{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../screens/fxml/ConfirmarExcluirLivro.fxml"));
            Parent root = loader.load();
            
            LivroModel livro = (LivroModel) Ilivro;
            ConfirmarExcluirLivroView confirmarExcluirLivroView = loader.getController();
            
            confirmarExcluirLivroView.setIdLivro(livro.getId());
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
