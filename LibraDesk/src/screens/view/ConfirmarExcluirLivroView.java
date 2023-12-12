package screens.view;


import conexaoDAO.Conexao;
import controller.AcervoController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.Action;
import javax.swing.JOptionPane;

import DAO.AcervoDAO;
import model.LivroModel;


public class ConfirmarExcluirLivroView {

    AcervoController acervoController = new AcervoController();
    int idLivro;
    
    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    @FXML
    protected void btConfirmar(ActionEvent e){
        acervoController.excluirLivro(idLivro);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void btCancelar(ActionEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }
}
