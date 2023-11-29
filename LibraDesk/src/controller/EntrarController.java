/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.ResultSet;
import conexaoDAO.Conexao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author CAIO
 */
public class EntrarController{

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtSenha;


    
    @FXML
    protected void btEntrar(ActionEvent e){
        if(verificaLogin(txtLogin.getText(), txtSenha.getText())){
            Main.changeScreen("acervo");
        }else{
            JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
        }
            

        
    }
    
    @FXML
    protected void btNovoCadastro(ActionEvent e){
        Main.changeScreen("novoUsuario");
    
    }

    public boolean verificaLogin(String login, String senha){
        Conexao conSing = Conexao.getInstancy();
        Connection conexao = conSing.getConexao();

        try {     
            String sql = "SELECT * FROM bibliotecaria";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                if(rs.getString("email").equals(login) && rs.getString("senha").equals(senha)){
                    return true;
                }
            }
            
        } catch (SQLException e) {       
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + e.getMessage());
        }

        return false;
    }
}
