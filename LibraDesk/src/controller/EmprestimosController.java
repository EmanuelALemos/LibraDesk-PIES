/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import conexaoDAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

import DAO.EmprestimoDAO;
import model.LivroModel;
import observer.IObservador;
import model.EmprestimoModel;
import model.LeitorModel;
import strategy.CalculadoraMulta;
import strategy.MultaEspecial;
import strategy.MultaPadrao;

/**
 * FXML Controller class
 *
 * @author CAIO
 */
public class EmprestimosController implements IController {

    EmprestimoDAO emprestimoDAO = new EmprestimoDAO();



    public void atualizarMultas(){
        emprestimoDAO.atualizarMultas();
    }


    public List<EmprestimoModel> pegarEmprestimos() {
        return emprestimoDAO.pegarEmprestimos();
    }

    public List<EmprestimoModel> buscarEmprestimo(String opcaoBusca, String campoPesquisado) {

        if (opcaoBusca.equals("Por leitor")) {
            System.out.println("controller");
            List<EmprestimoModel> emprestimos = emprestimoDAO.buscarEmprestimoPorLeitor(campoPesquisado);
            return emprestimos;
        } else if (opcaoBusca == "Por titulo") {
            List<EmprestimoModel> emprestimos = emprestimoDAO.buscarEmprestimoPorLivro(campoPesquisado);
            return emprestimos;
        } else {
            JOptionPane.showMessageDialog(null, "selecione uma forma de pesquisa desejado");
            return null;
            
        }

    }
    
    public void debitarEmprestimo(int idEmprestimo) {
        emprestimoDAO.debitarEmprestimo(idEmprestimo);
        
    }

}
