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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import DAO.EmprestimoDAO;
import model.EmprestimoModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.fxml.FXMLLoader;

/**
 * FXML Controller class
 *
 * @author arauj
 */
public class NovoEmprestimoController implements IController {

    EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

    public void adicionarEmprestimo(Date dataEmprestimo, Date dataPrevDevolucao,
            double multa, String cpfLeitor, String nomeLivro, int idLivro) throws Exception {
        emprestimoDAO.adicionarEmprestimo(dataEmprestimo, dataPrevDevolucao, multa, cpfLeitor,
                nomeLivro);
    }

}