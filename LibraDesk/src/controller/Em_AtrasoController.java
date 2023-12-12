/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import conexaoDAO.Conexao;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

import DAO.EmAtrasoDAO;
import model.EmprestimoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

/**
 * FXML Controller class
 *
 * @author CAIO
 */
public class Em_AtrasoController implements IController {

    EmAtrasoDAO emAtrasoDAO = new EmAtrasoDAO();

    public List<EmprestimoModel> pegarEmprestimos() {
        return emAtrasoDAO.pegarEmprestimos();
    }

    public List<EmprestimoModel> buscarEmprestimo(String opcaoBusca, String campoPesquisado) {

        if (opcaoBusca == "Por leitor") {
            List<EmprestimoModel> emprestimos = emAtrasoDAO.buscarEmprestimoPorLeitor(campoPesquisado);
            return emprestimos;
        } else if (opcaoBusca == "Por titulo") {
            List<EmprestimoModel> emprestimos = emAtrasoDAO.buscarEmprestimoPorLivro(campoPesquisado);
            return emprestimos;
        } else {
            JOptionPane.showMessageDialog(null, "selecione uma forma de pesquisa desejado");
            return null;
        }

    }

    public void debitarEmprestimo(int idEmprestimo) {
        emAtrasoDAO.debitarEmprestimo(idEmprestimo);
    }

}
