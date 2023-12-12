/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.util.*;
import java.sql.*;
import conexaoDAO.Conexao;
import java.net.URL;
import java.sql.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;

import DAO.AcervoDAO;
import javafx.scene.control.TextField;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.LivroModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author CAIO
 */
public class AcervoController implements IController {

    AcervoDAO acervoDAO = new AcervoDAO();

    AcervoController acervoController;

    public AcervoController getAcervoController() {
        return this;
    }

    public List<LivroModel> buscarLivrosPorTitulo(String titulo) {
        List<LivroModel> livros = acervoDAO.pesquisarLivroPorTitulo(titulo);
        return livros;
    }

    public List<LivroModel> pegarLivrosAcervo() {
        return acervoDAO.pegarLivrosAcervo();
    }

    public void excluirLivro(int id) {
        acervoDAO.excluirLivro(id);
    }

}
