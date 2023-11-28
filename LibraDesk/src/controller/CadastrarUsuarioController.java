/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexaoDAO.Conexao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.PessoaModel;
import model.BibliotecariaModel;

/**
 * FXML Controller class
 *
 * @author CAIO
 */
public class CadastrarUsuarioController{
    
    @FXML
    private TextField txtNomeUsuario;

    @FXML
    private TextField txtEmail;

    @FXML
    private MenuButton btOpcaoBusca;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtCpf;



    @FXML
    protected void btVoltar(ActionEvent e){
        Main.changeScreen("login");
    }

    @FXML
    protected void btCadastrar(ActionEvent e){
        openConfirmarPopup();
    }
    
    
    public void CadastrarUsuario(){
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();
        String nomeCompleto = txtNomeUsuario.getText();
        String[] partesNome = nomeCompleto.split(" ", 2);
        String primeiroNome = partesNome[0];
        String sobrenome = (partesNome.length > 1) ? partesNome[1] : "";

        PessoaModel pessoa = new PessoaModel(primeiroNome, sobrenome, txtCpf.getText());
        cadastrarPessoa(pessoa);
        BibliotecariaModel bibliotecaria = new BibliotecariaModel(primeiroNome, sobrenome, txtCpf.getText(), txtEmail.getText(), txtSenha.getText(), false);
        CadastrarBibliotecaria(bibliotecaria);
    }

    public void cadastrarPessoa(PessoaModel pessoa){
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();

        try{
            String sql = "INSERT INTO pessoa(pnome, sobrenome, cpf) VALUES(?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pessoa.getPnome());
            stmt.setString(2, pessoa.getSobrenome());
            stmt.setString(3, pessoa.getCpf());

            stmt.executeUpdate();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar pessoa: " + ex);

        }

    }

    public void CadastrarBibliotecaria(BibliotecariaModel bibliotecaria){
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();

        try{
            String sql = "INSERT INTO bibliotecaria(email, senha, coordenador, cpf) VALUES(?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, bibliotecaria.getEmail());
            stmt.setString(2, bibliotecaria.getSenha());
            stmt.setBoolean(3, false);
            stmt.setString(4, bibliotecaria.getCpf());

            stmt.executeUpdate();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar bibliotecaria: " + ex);
        }

    }
    

    private void openConfirmarPopup() {
        try {
            // Carregando o arquivo FXML da tela NovoLivro
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/ConfirmarCadastro.fxml"));
            Parent root = loader.load();

            ConfirmarCadastroController controller = loader.getController();
            controller.setCadastrarUsuarioController(this);
            // Criando um novo palco (Stage) para a tela NovoLivro
            Stage confirmarStage = new Stage();
            confirmarStage.setTitle("Confirmar Cadastro");
            confirmarStage.initStyle(StageStyle.UTILITY);
            confirmarStage.initModality(Modality.APPLICATION_MODAL);
            confirmarStage.setScene(new Scene(root, 480, 360));

            // Exibindo o palco
            confirmarStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
