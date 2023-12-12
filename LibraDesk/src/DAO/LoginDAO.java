package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexaoDAO.Conexao;

public class LoginDAO implements IDAO{
    Conexao conSing = Conexao.getInstancy();
    Connection conexao = conSing.getConexao();
    
    public boolean validarCampos(String login, String senha) {
        String loginCoordenador = "";
        String senhaCoordenador = "";

        try {
            String sql = "SELECT * FROM bibliotecaria WHERE coordenador = true";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                loginCoordenador = resultSet.getString("email");
                senhaCoordenador = resultSet.getString("senha");
                if(login.equals(loginCoordenador) && senha.equals(senhaCoordenador)){
                    return true;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados" + ex.getMessage());
        }

        return false;
    }   

    public boolean verificaLogin(String login, String senha){

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
