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
import model.LeitorModel;
import model.PessoaModel;

/**
 * FXML Controller class
 *
 * @author arauj
 */
public class NovoLeitorController{
    
    @FXML
    private TextField nomeLeitor;
    @FXML
    private TextField cpfLeitor;
    @FXML
    private TextField telefone1Leitor;
    @FXML
    private TextField telefone2Leitor;
    @FXML
    private TextField cidadeLeitor;
    @FXML
    private TextField bairroLeitor;
    @FXML
    private TextField ruaLeitor;
    @FXML
    private TextField numeroLeitor;

    @FXML
    public void btCadastrarLeitor(ActionEvent e) {
        String nomeCompleto = nomeLeitor.getText();
        String[] partesNome = nomeCompleto.split(" ", 2);
        String primeiroNome = partesNome[0];
        String sobrenome = (partesNome.length > 1) ? partesNome[1] : "";
        
        PessoaModel pessoa = new PessoaModel(primeiroNome, sobrenome, cpfLeitor.getText());
        adicionarPessoa(pessoa);
        
        
        LeitorModel leitor = new LeitorModel(
                primeiroNome,
                sobrenome,
                cpfLeitor.getText(),
                telefone1Leitor.getText(),
                telefone2Leitor.getText(),
                bairroLeitor.getText(),
                ruaLeitor.getText(),
                cidadeLeitor.getText(),
                Integer.parseInt(numeroLeitor.getText())
        );
        
        adicionarLeitor(leitor);
        Main.changeScreen("leitores");
    }
    
    public void adicionarPessoa(PessoaModel pessoa){
        try{
            Conexao conSing = Conexao.getInstancy();
            Connection conexao = conSing.getConexao();
            String sql = "INSERT INTO Pessoa(pnome, sobrenome, cpf) VALUES (?,?,?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, pessoa.getPnome());
            preparedStatement.setString(2, pessoa.getSobrenome());
            preparedStatement.setString(3, pessoa.getCpf());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + ex.getMessage());
        }
    }

    public void adicionarLeitor(LeitorModel leitor) {
        try {
            Conexao conSing = Conexao.getInstancy();
            Connection conexao = conSing.getConexao();

            String sql = "INSERT INTO Leitor (telefone_um, telefone_dois, cpf, bairro, rua, cidade, numero) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, leitor.getTelefoneUm());
            preparedStatement.setString(2, leitor.getTelefoneDois());
            preparedStatement.setString(3, leitor.getCpf());
            preparedStatement.setString(4, leitor.getBairro());
            preparedStatement.setString(5, leitor.getRua());
            preparedStatement.setString(6, leitor.getCidade());
            preparedStatement.setInt(7, leitor.getNumero());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + ex.getMessage());
        }
    }

    public void btCancelarLeitor(ActionEvent e) {
        Main.changeScreen("leitores");
    }
  
}
