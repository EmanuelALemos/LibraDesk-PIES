package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexaoDAO.Conexao;
import model.EmprestimoModel;

public class EmAtrasoDAO implements IDAO{
    
    Conexao conSing = Conexao.getInstancy();
    Connection conexao = conSing.getConexao();
    
    public List<EmprestimoModel> buscarEmprestimoPorLeitor(String nomeLeitor) {
        

        List<EmprestimoModel> listaEmprestimo = new ArrayList<>();

        try {

            String sql = "SELECT * FROM emprestimo e JOIN pessoa p ON e.cpf_leitor = p.cpf JOIN livro l ON l.id = e.id_livro WHERE (p.pnome || ' ' || p.sobrenome) LIKE ? AND "
                    + "e.status = true AND e.data_prev_dev < ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            LocalDate dataAtual = LocalDate.now();
            java.sql.Date dataPrevDevolucao = java.sql.Date.valueOf(dataAtual);
            preparedStatement.setDate(2, dataPrevDevolucao);
            preparedStatement.setString(1, "%" + nomeLeitor + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nomeCompleto;
                if(resultSet.getString("sobrenome") != null){
                            nomeCompleto = resultSet.getString("pnome") + " " + resultSet.getString("sobrenome");
                }else{
                    nomeCompleto = resultSet.getString("pnome");
                }
                
                EmprestimoModel emprestimo = new EmprestimoModel(
                        nomeCompleto,
                        resultSet.getDate("data_emprestimo"),
                        resultSet.getDate("data_prev_dev"),
                        resultSet.getDate("data_real_dev"),
                        resultSet.getDouble("multa"),
                        resultSet.getString("cpf_leitor"),
                        resultSet.getString("titulo"),
                        resultSet.getInt("id_livro"),
                        resultSet.getBoolean("status"),
                        resultSet.getInt("id_emprestimo")
                );

                listaEmprestimo.add(emprestimo);
            }

        } catch (SQLException excecaoLeitor) {
            excecaoLeitor.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + excecaoLeitor.getMessage());
        }

        return listaEmprestimo;
    }

    public List<EmprestimoModel> buscarEmprestimoPorLivro(String tituloLivro) {

        List<EmprestimoModel> listaEmprestimo = new ArrayList<>();

        try {

            String sql = "SELECT * FROM emprestimo e JOIN pessoa p ON e.cpf_leitor = p.cpf JOIN livro l ON l.id = e.id_livro WHERE l.titulo LIKE ? AND e.status = true AND e.data_prev_dev < ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            LocalDate dataAtual = LocalDate.now();
            java.sql.Date dataPrevDevolucao = java.sql.Date.valueOf(dataAtual);
            preparedStatement.setDate(2, dataPrevDevolucao);
            preparedStatement.setString(1, "%" + tituloLivro + "%");
            
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nomeCompleto;
                if(resultSet.getString("sobrenome") != null){
                            nomeCompleto = resultSet.getString("pnome") + " " + resultSet.getString("sobrenome");
                }else{
                    nomeCompleto = resultSet.getString("pnome");
                }
                
                EmprestimoModel emprestimo = new EmprestimoModel(
                        nomeCompleto,
                        resultSet.getDate("data_emprestimo"),
                        resultSet.getDate("data_prev_dev"),
                        resultSet.getDate("data_real_dev"),
                        resultSet.getDouble("multa"),
                        resultSet.getString("cpf_leitor"),
                        resultSet.getString("titulo"),
                        resultSet.getInt("id_livro"),
                        resultSet.getBoolean("status"),
                        resultSet.getInt("id_emprestimo")
                );

                listaEmprestimo.add(emprestimo);
            }

        } catch (SQLException excecaoLeitor) {
            excecaoLeitor.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado: " + excecaoLeitor.getMessage());
        }

        return listaEmprestimo;
    }

    public List<EmprestimoModel> pegarEmprestimos() {

        List<EmprestimoModel> listaEmprestimo = new ArrayList<>();

        try {

            String sql = "SELECT * FROM emprestimos_atrasados_view";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nomeCompleto;
                if(resultSet.getString("sobrenome") != null){
                            nomeCompleto = resultSet.getString("pnome") + " " + resultSet.getString("sobrenome");
                }else{
                    nomeCompleto = resultSet.getString("pnome");
                }
                
                EmprestimoModel emprestimo = new EmprestimoModel(
                        nomeCompleto,
                        resultSet.getDate("data_emprestimo"),
                        resultSet.getDate("data_prev_dev"),
                        resultSet.getDate("data_real_dev"),
                        resultSet.getDouble("multa"),
                        resultSet.getString("cpf_leitor"),
                        resultSet.getString("titulo"),
                        resultSet.getInt("id_livro"),
                        resultSet.getBoolean("status"),
                        resultSet.getInt("id_emprestimo")
                );

                listaEmprestimo.add(emprestimo);
            }

        } catch (SQLException excecaoLeitor) {
            excecaoLeitor.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado 3 " + excecaoLeitor.getMessage());
        }

        return listaEmprestimo;
    }

    public void debitarEmprestimo(int idEmprestimo) {

        try {
            String sql = "UPDATE Emprestimo SET status = false WHERE id_emprestimo = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, idEmprestimo);
            preparedStatement.executeUpdate();

        } catch (SQLException excecaoLeitor) {
            excecaoLeitor.printStackTrace();
            JOptionPane.showMessageDialog(null, "Deu errado 4 " + excecaoLeitor.getMessage());
        }
    }
}