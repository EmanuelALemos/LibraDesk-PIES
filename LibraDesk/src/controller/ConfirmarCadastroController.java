package controller;

import conexaoDAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import screens.view.FuncionariosView;
import screens.view.NovoFuncionarioView;

import javax.swing.JOptionPane;
import org.w3c.dom.Node;

import DAO.LoginDAO;
import javafx.scene.control.PasswordField;

public class ConfirmarCadastroController implements IController {

    CadastrarUsuarioController cadastrarUsuarioController = new CadastrarUsuarioController();
    LoginDAO loginDAO = new LoginDAO();

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtSenha;

    public NovoFuncionarioView novoFuncionarioView;
    public FuncionariosView funcionariosView;
    public String view;


    public void setNovoFuncionarioView(NovoFuncionarioView novoFuncionarioView, String view) {
        this.novoFuncionarioView = novoFuncionarioView;
        this.view = view;
    }

    public void setFuncionariosView(FuncionariosView funcionariosView, String view) {
        this.funcionariosView = funcionariosView;
        this.view = view;
    }

    @FXML
    protected void btConfirmar(ActionEvent e) throws Exception {
        String login = txtLogin.getText();
        String senha = txtSenha.getText();


        if (loginDAO.validarCampos(login, senha)) {
            if(view.equals("NovoFuncionarioView")){
                novoFuncionarioView.CadastrarUsuario();
            }else if(view.equals("excluirFuncionarioView")){
                System.out.println("Entrou no excluir");
                funcionariosView.excluirFuncionario();
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
        }
    }

    @FXML
    protected void btCancelar(ActionEvent e) throws Exception {
        Main.changeScreen("novoUsuario");
    }

    
}
