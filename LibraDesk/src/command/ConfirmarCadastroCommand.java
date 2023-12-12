package command;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import controller.CadastrarUsuarioController;
import controller.ConfirmarCadastroController;
import controller.Main;
import model.BibliotecariaModel;
import model.IModel;

public class ConfirmarCadastroCommand implements PopUpCommand {

    CadastrarUsuarioController cadastrarUsuarioController = new CadastrarUsuarioController();

    public void execute(IModel model) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../screens/fxml/ConfirmarCadastro.fxml"));
            Parent root = loader.load();

            BibliotecariaModel bibliotecariaModel = (BibliotecariaModel) model;
            cadastrarUsuarioController.CadastrarUsuario(bibliotecariaModel.getPnome(), bibliotecariaModel.getSobrenome(), bibliotecariaModel.getCpf(), bibliotecariaModel.getEmail(), bibliotecariaModel.getSenha(), bibliotecariaModel.isCoordenador());
            // Criando um novo palco (Stage) para a tela NovoLivro
            Stage confirmarStage = new Stage();
            confirmarStage.setTitle("Confirmar Cadastro");
            confirmarStage.initStyle(StageStyle.UTILITY);
            confirmarStage.initModality(Modality.APPLICATION_MODAL);
            confirmarStage.setScene(new Scene(root, 480, 360));

            // Exibindo o palco
            confirmarStage.showAndWait();
    }
}
