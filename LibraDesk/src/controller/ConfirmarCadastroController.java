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
import javax.swing.JOptionPane;
import org.w3c.dom.Node;

public class ConfirmarCadastroController {

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    public CadastrarUsuarioController cadastrarUsuarioController;

    public void setCadastrarUsuarioController(CadastrarUsuarioController cadastrarUsuarioController) {
        this.cadastrarUsuarioController = cadastrarUsuarioController;
    }

    @FXML
    protected void btConfirmar(ActionEvent e) {
        String login = txtLogin.getText();
        String senha = txtSenha.getText();

        if (validarCampos()) {
            cadastrarUsuarioController.CadastrarUsuario();
            //Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            //stage.close();
        } else {
            JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
        }
    }

    @FXML
    protected void btCancelar(ActionEvent e) {
        Main.changeScreen("novoUsuario");
    }

    public boolean validarCampos() {
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();
        String loginCoordenador = "";
        String senhaCoordenador = "";

        try {
            String sql = "SELECT * FROM bibliotecaria WHERE coordenador = true";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                loginCoordenador = resultSet.getString("email");
                senhaCoordenador = resultSet.getString("senha");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados" + ex.getMessage());
        }

        String login = txtLogin.getText();
        String senha = txtSenha.getText();

        return login.equals(loginCoordenador) && senha.equals(senhaCoordenador);
    }
}
