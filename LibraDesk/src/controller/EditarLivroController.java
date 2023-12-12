/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import conexaoDAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import DAO.AcervoDAO;
import model.LivroModel;
import screens.view.AcervoView;
import model.IModel;

/**
 *
 * @author gabri
 */
public class EditarLivroController implements IController {


    AcervoDAO acervoDAO = new AcervoDAO();

    public void EditarLivro(String titulo, String localBiblioteca, int numeroExemplares, String autor, int idLivro) {
        acervoDAO.EditarLivro(titulo, localBiblioteca, numeroExemplares, autor, idLivro);
    }
}
