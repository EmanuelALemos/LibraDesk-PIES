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
import model.LeitorModel;
import model.PessoaModel;
/**
 *
 * @author gabri
 */
public class EditarLeitorController {
    
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
    
    private LeitoresController leitoresController;

    public void setLeitoresController(LeitoresController leitoresController) {
        this.leitoresController = leitoresController;
    }
    
    
    public void preencherCampos(LeitorModel leitor){
        nomeLeitor.setText(leitor.getNomeCompleto());
        cpfLeitor.setText(leitor.getCpf());
        telefone1Leitor.setText(leitor.getTelefoneUm());
        telefone2Leitor.setText(leitor.getTelefoneDois());
        ruaLeitor.setText(leitor.getRua());
        cidadeLeitor.setText(leitor.getCidade());
        bairroLeitor.setText(leitor.getBairro());
        numeroLeitor.setText(String.valueOf(leitor.getNumero()));
    }
    
    @FXML
    public void btEditarLeitor(ActionEvent e){
        String nomeCompleto = nomeLeitor.getText();
        String[] partesNome = nomeCompleto.split(" ", 2);
        String primeiroNome = partesNome[0];
        String sobrenome = (partesNome.length > 1) ? partesNome[1] : "";
        
        
        PessoaModel pessoa = new PessoaModel(primeiroNome, sobrenome, cpfLeitor.getText());
        editarPessoa(pessoa);
        
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
        
        editarLeitor(leitor);
        leitoresController.atualizarTabela();  
        Main.changeScreen("leitores");
        
    }
    
    public void editarPessoa(PessoaModel pessoa){
        try{
            Conexao conSing = Conexao.getInstancy();
            Connection conexao = conSing.getConexao();
            String sql = "UPDATE Pessoa SET Pnome = ?, sobrenome = ? WHERE cpf = ?";
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
    
    public void editarLeitor(LeitorModel leitor){
        try {
            Conexao conSing = Conexao.getInstancy();
            Connection conexao = conSing.getConexao();

            String sql = "UPDATE Leitor SET telefone_um = ?, telefone_dois = ?, bairro = ?, rua = ?, cidade = ?, numero = ? WHERE cpf = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, leitor.getTelefoneUm());
            preparedStatement.setString(2, leitor.getTelefoneDois());
            preparedStatement.setString(3, leitor.getBairro());
            preparedStatement.setString(4, leitor.getRua());
            preparedStatement.setString(5, leitor.getCidade());
            preparedStatement.setInt(6, leitor.getNumero());
            preparedStatement.setString(7, leitor.getCpf());

            preparedStatement.executeUpdate();
            Main.changeScreen("leitores");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + ex.getMessage());
        }
    }
    
    
    @FXML
    public void btCancelarLeitor(ActionEvent e) {
        Main.changeScreen("leitores");
    }
}
