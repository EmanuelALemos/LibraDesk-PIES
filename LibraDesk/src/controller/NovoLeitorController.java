/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;


import conexaoDAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.EmprestimoModel;

/**
 * FXML Controller class
 *
 * @author arauj
 */
public class NovoLeitorController{
    
    @FXML
    private TextField nomeLeitorEmprestimo;
    @FXML
    private TextField cpfLeitorEmprestimo;
    @FXML
    private TextField livroEmprestimo;
    @FXML
    private TextField dataEmprestimo;
    @FXML
    private TextField dataDevolucao;
    
    private Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            // Em caso de erro na conversão
            e.printStackTrace(); // Trate o erro de acordo com sua necessidade
            return null; // Ou lance uma exceção, dependendo do seu fluxo de controle
        }
    }
    
    
    
    @FXML
    public void btCadastrarLeitor(ActionEvent e) {
        // Criando um empréstimo com multa=0, dataRealDev=null e status=true
        EmprestimoModel emprestimo = new EmprestimoModel(
                parseDate(dataEmprestimo.getText()),
                parseDate(dataDevolucao.getText()), 
                null, 
                0, 
                cpfLeitorEmprestimo.getText(),
                0, 
                true 
        );

    
        Main.changeScreen("leitores");
    }


    public void btCancelarLeitor(ActionEvent e) {
        Main.changeScreen("leitores");
    }
    
}
