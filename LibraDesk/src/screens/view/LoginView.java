package screens.view;

import javax.swing.JOptionPane;

import controller.LoginController;
import controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginView {

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtSenha;

    public LoginController controller = new LoginController();

    @FXML
    protected void btEntrar(ActionEvent e) throws Exception {
        String login = txtLogin.getText();
        String senha = txtSenha.getText();

        if(controller.validarCampos(login, senha)){
            Main.changeScreen("acervo");
        }else{
            JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
        }
    }
    
    @FXML
    protected void btNovoCadastro(ActionEvent e)throws Exception {
        Main.changeScreen("novoUsuario");
    
    }
}
