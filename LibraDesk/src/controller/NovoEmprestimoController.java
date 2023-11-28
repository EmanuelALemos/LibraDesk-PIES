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
public class NovoEmprestimoController{
    
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

    EmprestimosController emprestimoController = new EmprestimosController();
    
    
    public void setEmprestimoController(EmprestimosController emprestimoController){
        this.emprestimoController = emprestimoController;
    }
    
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
    public void btCadastrarEmprestimo(ActionEvent e) {
        // Criando um empréstimo com multa=0, dataRealDev=null e status=true
        EmprestimoModel emprestimo = new EmprestimoModel(
                nomeLeitorEmprestimo.getText(),
                parseDate(dataEmprestimo.getText()),
                parseDate(dataDevolucao.getText()), 
                parseDate(dataDevolucao.getText()), 
                0, 
                cpfLeitorEmprestimo.getText(),
                livroEmprestimo.getText(),
                0, 
                true,
                0
        );
        
        adicionarEmprestimo(emprestimo);

        emprestimoController.atualizarTabela();
        Main.changeScreen("emprestimos");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }
    
    public void adicionarEmprestimo(EmprestimoModel emprestimo){
        
        try{
            Conexao conSing = Conexao.getInstancy();
            Connection conexao = conSing.getConexao();
            
            int idLivro = pegarIdLivro(emprestimo.getNomeLivro());String sql = "INSERT INTO emprestimo (data_emprestimo, data_prev_dev, data_real_dev, multa, cpf_leitor, id_livro, status) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);        
            preparedStatement.setDate(1, new java.sql.Date(emprestimo.getDataEmprestimo().getTime()));
            preparedStatement.setDate(2, new java.sql.Date(emprestimo.getDataPrevDev().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(emprestimo.getDataRealDev().getTime()));
            preparedStatement.setDouble(4, emprestimo.getMulta());
            preparedStatement.setString(5, emprestimo.getCpfLeitor());
            preparedStatement.setInt(6, idLivro);
            preparedStatement.setBoolean(7, emprestimo.isStatus());
            
            
            preparedStatement.executeUpdate();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + ex.getMessage());
        }
        
    }
    
    public int pegarIdLivro(String nomeLivro){
        int idLivro = -1;
        
        try{
            Conexao conSing = Conexao.getInstancy();
            Connection conexao = conSing.getConexao();
            
            String sql = "SELECT id FROM livro WHERE titulo = ?";
            
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nomeLivro);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                idLivro = resultSet.getInt("id");
                // Agora, 'idLivro' contém o valor do id do primeiro livro encontrado com o título fornecido.
            } else {
                // Caso não haja resultados para o título fornecido.
                JOptionPane.showMessageDialog(null, "Livro nao existe");
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + ex.getMessage());
        }
        
        return idLivro;
        
    }


    public void btCancelarEmprestimo(ActionEvent e) {
        Main.changeScreen("emprestimos");
    }
    
}
