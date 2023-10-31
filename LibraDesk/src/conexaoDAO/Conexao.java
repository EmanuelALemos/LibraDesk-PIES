/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexaoDAO;


import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexao{
    private Connection conexao;
    private String url = "jdbc:postgresql://localhost:5432/LibraDesk";
    private String user = "postgres";
    private String senha = "1263";
    private static Conexao instancy;
    
    private Conexao(){
        try{
            Class.forName("org.postgresql.Driver");
            JOptionPane.showMessageDialog(null, "Driver OK!");
        }catch(HeadlessException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Driver nao encontrado");
        }
        
        try{
            this.conexao = DriverManager.getConnection(url, user, senha);
            JOptionPane.showMessageDialog(null, "Conexão OK!");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }    
    /**
     *
     * @return
     */
    public static Conexao getInstancy(){
        if(instancy == null){
            instancy = new Conexao();
        }
        return instancy;
    }
        
    public Connection getConexao(){
        return this.conexao;
    }
        
    
}
