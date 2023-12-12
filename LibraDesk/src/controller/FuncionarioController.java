/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import DAO.FuncionarioDAO;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import conexaoDAO.Conexao;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.BibliotecariaModel;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
/**
 * FXML Controller class
 *
 * @author arauj
 */
public class FuncionarioController implements IController {

    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public List<BibliotecariaModel> getFuncionarios(){
        return funcionarioDAO.getFuncionarios();
    }
<<<<<<< HEAD
=======

    public void excluirFuncionario(String cpf){
        System.out.println("Entrou no excluir controller");
        funcionarioDAO.excluirFuncionario(cpf);
    }

>>>>>>> 1345a14cfa6ece47d1421395557146f4a1d0b3e8
    
}
