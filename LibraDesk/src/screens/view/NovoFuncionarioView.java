package screens.view;

import command.*;
import controller.CadastrarUsuarioController;
import controller.ConfirmarCadastroController;
import controller.Main;
import model.BibliotecariaModel;
import model.PessoaModel;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NovoFuncionarioView{
    InvokerPopUpCommand invokerPopUpCommand = new InvokerPopUpCommand();
    CadastrarUsuarioController cadastrarUsuarioController = new CadastrarUsuarioController();

    @FXML
    private TextField txtNomeUsuario;

    @FXML
    private TextField txtEmail;

    @FXML
    private MenuButton menuButtomCargo;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private TextField txtCpf;

    @FXML
    public void initialize() {

        MenuItem item1 = new MenuItem("Coordenador(a)");
        MenuItem item2 = new MenuItem("Bibliotecario(a)");

        item1.setOnAction(event -> handleOpcaoSelecionada(item1));
        item2.setOnAction(event -> handleOpcaoSelecionada(item2));

        menuButtomCargo.getItems().addAll(item1, item2);
        invokerPopUpCommand.register("confirmarCadastro", new ConfirmarCadastroCommand());
    }

    private void handleOpcaoSelecionada(MenuItem menuItem) {
        // Atualiza o texto do MenuButton com o texto do item selecionado
        menuButtomCargo.setText(menuItem.getText());
        String estiloCSS = "-fx-text-fill: black;"; // Substitua "black" pela cor desejada

        menuButtomCargo.setStyle(estiloCSS);

    }

    public boolean getCargo() {
        if (menuButtomCargo.getText().equals("Coordenador(a)")) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    protected void btVoltar(ActionEvent e) throws Exception {
        Main.changeScreen("login");
    }

    @FXML
    protected void btCadastrar(ActionEvent e) throws Exception {

        openConfirmarPopup();
    }

    public void CadastrarUsuario() {
        String nomeCompleto = txtNomeUsuario.getText();
        String[] partesNome = nomeCompleto.split(" ", 2);
        String primeiroNome = partesNome[0];
        String sobrenome = (partesNome.length > 1) ? partesNome[1] : null;

        cadastrarUsuarioController.CadastrarUsuario(primeiroNome, sobrenome, txtCpf.getText(), txtEmail.getText(),
                txtSenha.getText(), getCargo());

    }

    private void openConfirmarPopup() {
        try {
            // Carregando o arquivo FXML da tela ConfirmarCadastro
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/ConfirmarCadastro.fxml"));
            Parent xmlConfirmarCadastro = loader.load();

            ConfirmarCadastroController controller = loader.getController();
            controller.setNovoFuncionarioView(this, "NovoFuncionarioView");

            // Criando um novo palco (Stage) para a tela ConfirmarCadastro
            Stage confirmarStage = new Stage();
            confirmarStage.setTitle("Confirmar Cadastro");
            confirmarStage.initStyle(StageStyle.UTILITY);
            confirmarStage.initModality(Modality.APPLICATION_MODAL);
            confirmarStage.setScene(new Scene(xmlConfirmarCadastro, 480, 360));

            // Exibindo o palco
            confirmarStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
