package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import conexaoDAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

import DAO.LeitoresDAO;
import model.LeitorModel;
import model.PessoaModel;

/**
 *
 * @author gabri
 */
public class EditarLeitorController implements IController {

    LeitoresDAO leitoresDAO = new LeitoresDAO();
    
    public void editarPessoa(String pnome, String sobrenome, String cpf) {
        leitoresDAO.editarPessoa(pnome, sobrenome, cpf);
    }
    
    public void editarLeitor(String telefoneUm, String telefoneDois, String cpf, String bairro, String rua, String cidade, int numero) throws Exception {
        leitoresDAO.editarLeitor(telefoneUm, telefoneDois, cpf, bairro, rua, cidade, numero);
    }
    
}
