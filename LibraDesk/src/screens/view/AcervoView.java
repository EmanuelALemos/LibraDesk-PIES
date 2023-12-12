package screens.view;

import java.util.List;

import javax.swing.JOptionPane;
import java.util.*;
import java.sql.*;
import conexaoDAO.Conexao;
import java.net.URL;
import java.sql.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;
import DAO.AcervoDAO;
import command.*;
import javafx.scene.control.TextField;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.LivroModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import DAO.AcervoDAO;
import controller.*;
import model.LivroModel;

public class AcervoView {
    
    InvokerPopUpCommand invoker = new InvokerPopUpCommand();
    
    AcervoController acervoController = new AcervoController();
    
    @FXML
    private TextField txtTituloPesquisado;

    public String getTextField() {
        return txtTituloPesquisado.getText();
    }

    @FXML
    protected void btNovoLivro(ActionEvent e) throws Exception {
        Main.changeScreen("novoLivro");
    }
    
    @FXML
    protected void btLeitores(ActionEvent e) throws Exception {
        Main.changeScreen("leitores");
    }
    
    @FXML
    protected void btEmprestimos(ActionEvent e) throws Exception {
        Main.changeScreen("emprestimos");
    }
    
    @FXML
    protected void btEmAtraso(ActionEvent e) throws Exception {
        Main.changeScreen("em_atraso");
    }
    
    @FXML
    protected void btFuncionario(ActionEvent e) throws Exception {
        Main.changeScreen("funcionario");
    }
    
    @FXML
    protected void btSair(ActionEvent e) throws Exception {
        Main.changeScreen("login");
    }
    
    @FXML
    private TableView<LivroModel> livrosTableView;
    
    @FXML
    public void initialize() {
        invoker.register("editarLivro", new EditarLivroCommand()); 
        invoker.register("excluirLivro", new ExcluirLivroCommand());
        
        TableColumn<LivroModel, String> colTitulo = new TableColumn("Titulo");
        colTitulo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTitulo()));

        TableColumn<LivroModel, String> colAutor = new TableColumn("Autor");
        colAutor.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAutor()));
        
        TableColumn<LivroModel, String> colLocalizacao = new TableColumn("Localizacao");
        colLocalizacao.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLocalBiblioteca()));
        
        TableColumn<LivroModel, Integer> colNumExemplares = new TableColumn("Numero Exemplares");
        colNumExemplares.setCellValueFactory(
            data -> new SimpleIntegerProperty(data.getValue().getNumeroExemplares()).asObject());
            
            TableColumn<LivroModel, Integer> colId = new TableColumn("Id");
            colId.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()).asObject());
            
            livrosTableView.getColumns().addAll(colId, colTitulo, colAutor, colLocalizacao, colNumExemplares);
            
            atualizarTabela();
        }
        
    public void atualizarTabela() {
        List<LivroModel> acervo = acervoController.pegarLivrosAcervo();
        preencherTableView(acervo);
    }

    @FXML
    protected void btBuscarLivrosPorTitulo(ActionEvent event) {
        String titulo = txtTituloPesquisado.getText();
        List<LivroModel> livros = acervoController.buscarLivrosPorTitulo(titulo);
        preencherTableView(livros);
    }
    
    public void preencherTableView(List<LivroModel> livros) {
        ObservableList<LivroModel> livrosObservableList = FXCollections.observableArrayList(livros);
        livrosTableView.setItems(livrosObservableList);
    }
    
    @FXML
    public void btExcluirLivro(ActionEvent e) throws Exception {
        LivroModel livroSelecionado = livrosTableView.getSelectionModel().getSelectedItem();

        if (livroSelecionado == null) {
            return;
        }

        invoker.invoke("excluirLivro", livroSelecionado);
        Main.changeScreen("acervo");
    }
    
    @FXML
    public void btEditarLivro(ActionEvent e) throws Exception {
        LivroModel livroSelecionado = livrosTableView.getSelectionModel().getSelectedItem();

        if (livroSelecionado == null) {
            return;
        }

        invoker.invoke("editarLivro", livroSelecionado);
    }

}
