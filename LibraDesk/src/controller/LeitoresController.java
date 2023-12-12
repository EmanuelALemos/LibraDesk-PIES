/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import javafx.collections.ObservableList;
import conexaoDAO.Conexao;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.LeitorModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javax.swing.JOptionPane;

import DAO.LeitoresDAO;

/**
 * FXML Controller class
 *
 * @author CAIO
 */
public class LeitoresController implements IController {

    LeitoresDAO leitoresDAO = new LeitoresDAO();

    public List<LeitorModel> pegarLeitores() {
        return leitoresDAO.pegarLeitores();
    }
    
    public List<LeitorModel> buscarLeitorPorNome(String nome) {
        List<LeitorModel> leitores = leitoresDAO.pesquisarLeitorPorNome(nome);
        return leitores;
    }

    public void excluirLeitor(String cpf) {

        leitoresDAO.excluirLeitor(cpf);
    }

}
