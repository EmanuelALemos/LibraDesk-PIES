package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexaoDAO.Conexao;
import model.BibliotecariaModel;

public class FuncionarioDAO implements IDAO{

    Conexao conSing = Conexao.getInstancy();
    Connection conexao = conSing.getConexao();

    public List<BibliotecariaModel> getFuncionarios(){
        List<BibliotecariaModel> listaBibliotecaria = new ArrayList<>();

        try{
            String sql = "SELECT * FROM bibliotecaria b JOIN pessoa p ON b.cpf = p.cpf";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                BibliotecariaModel bibliotecaria = new BibliotecariaModel(
                    rs.getString("pnome"),
                    rs.getString("sobrenome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getBoolean("coordenador")
                );
                

                listaBibliotecaria.add(bibliotecaria);
            }

        }catch (SQLException exececaoAcervo) {
            exececaoAcervo.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + exececaoAcervo.getMessage());
        }

        return listaBibliotecaria;
    }

    public void cadastrarPessoa(String primeiroNome, String sobrenome, String cpf){

        try{
            String sql = "INSERT INTO pessoa(pnome, sobrenome, cpf) VALUES(?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, primeiroNome);
            stmt.setString(2, sobrenome);
            stmt.setString(3, cpf);

            stmt.executeUpdate();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar pessoa: " + ex);

        }

    }

    public void excluirFuncionario(String cpf){
        
        try{
            String sql = "DELETE FROM Pessoa WHERE cpf = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, cpf);
            System.out.println("Entrou no excluir dao: " + sql);
            preparedStatement.executeUpdate();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao excluir funcionario: " + ex);
        }
    }

    public void CadastrarBibliotecaria(String email, String senha, String cpf, boolean coordenador){
    
        try{
            String sql = "INSERT INTO bibliotecaria(email, senha, coordenador, cpf) VALUES(?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2,senha);
            stmt.setBoolean(3, coordenador);
            stmt.setString(4, cpf);

            stmt.executeUpdate();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar bibliotecaria: " + ex);
        }

    }
}
