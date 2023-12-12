package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexaoDAO.Conexao;
import model.LivroModel;

public class AcervoDAO implements IDAO{
    Conexao conSing = Conexao.getInstancy();
    Connection conexao = conSing.getConexao();

    public List<LivroModel> pegarLivrosAcervo() {
        List<LivroModel> listaLivros = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Livro";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LivroModel livro = new LivroModel();
                livro.setId(resultSet.getInt("id"));
                livro.setTitulo(resultSet.getString("titulo"));
                livro.setAutor(resultSet.getString("autor"));
                livro.setLocalBiblioteca(resultSet.getString("local_biblioteca"));
                livro.setNumeroExemplares(resultSet.getInt("num_exemplares"));
                listaLivros.add(livro);
            }
        } catch (SQLException exececaoAcervo) {
            exececaoAcervo.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + exececaoAcervo.getMessage());
        }

        return listaLivros;
    }

    public List<LivroModel> pesquisarLivroPorTitulo(String titulo) {
        // JOptionPane.showMessageDialog(null, " OK! ");
        List<LivroModel> listaLivros = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Livro WHERE titulo LIKE ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, "%" + titulo + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LivroModel livro = new LivroModel();
                livro.setId(resultSet.getInt("id"));
                livro.setTitulo(resultSet.getString("titulo"));
                livro.setAutor(resultSet.getString("autor"));
                livro.setLocalBiblioteca(resultSet.getString("local_biblioteca"));
                livro.setNumeroExemplares(resultSet.getInt("num_exemplares"));
                listaLivros.add(livro);
            }
        } catch (SQLException exececaoAcervo) {
            exececaoAcervo.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + exececaoAcervo.getMessage());
        }

        return listaLivros;
    }

    public void excluirLivro(int idLivro) {
        try {
            String sql = "DELETE FROM Livro WHERE id = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1,idLivro);

            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void adicionarLivro(String titulo, String localBiblioteca, int numeroExemplares, String autor) {
        try {    
            String sql = "INSERT INTO Livro (titulo, local_biblioteca, num_exemplares, exemplares_disponiveis, autor) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, localBiblioteca);
            preparedStatement.setInt(3, numeroExemplares);
            preparedStatement.setInt(4, numeroExemplares); 
            preparedStatement.setString(5, autor);
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {       
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + e.getMessage());
        }
    }
    

    public void EditarLivro(String titulo, String localBiblioteca, int numeroExemplares, String autor, int idLivro) {
           
        try{
            String sql = "UPDATE Livro SET titulo = ?, local_biblioteca = ?, num_exemplares = ?, autor = ? WHERE id = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, localBiblioteca);
            preparedStatement.setInt(3, numeroExemplares);
            preparedStatement.setString(4, autor);    
            preparedStatement.setInt(5, idLivro);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + ex.getMessage());
        }
    
    }
}
