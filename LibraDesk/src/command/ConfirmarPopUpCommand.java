package command;

import controller.ConfirmarCadastroController;
import controller.Main;
import model.IModel;

public class ConfirmarPopUpCommand implements Command {
    public void execute() throws Exception {
        try {
            // Carregando o arquivo FXML da tela NovoLivro
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/ConfirmarCadastro.fxml"));
            Parent root = loader.load();

            ConfirmarCadastroController controller = loader.getController();
            // controller.setCadastrarUsuarioController(this);
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
