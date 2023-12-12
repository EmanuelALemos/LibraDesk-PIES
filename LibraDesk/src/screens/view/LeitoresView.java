package screens.view;

import command.Command;
import command.EditarLeitorCommand;
import command.ExcluirLeitorCommand;
import javafx.collections.ObservableList;
import conexaoDAO.Conexao;
import controller.EditarLeitorController;
import controller.LeitoresController;
import controller.Main;
import controller.NovoLeitorController;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.LeitorModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javax.swing.JOptionPane;

import command.Invoker;
import command.InvokerPopUpCommand;


public class LeitoresView {
    LeitoresController leitoresController = new LeitoresController();
    InvokerPopUpCommand invoker = new InvokerPopUpCommand();

    @FXML
    private TextField txtLeitorPesquisado;

    @FXML
    private TableView<LeitorModel> leitoresTableView;

    @FXML
    protected void btAcervo(ActionEvent e) throws Exception {
        Main.changeScreen("acervo");
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
    protected void btNovoLeitor(ActionEvent e) throws Exception {
        Main.changeScreen("novoLeitor");
    }

    @FXML
    protected void btSair(ActionEvent e) throws Exception {
        Main.changeScreen("login");
    }

    @FXML
    protected void btFuncionario(ActionEvent e) throws Exception {
        Main.changeScreen("funcionario");
    }

    @FXML
    protected void btEditarLeitor(ActionEvent e) throws Exception{
        LeitorModel leitorSelecionado = leitoresTableView.getSelectionModel().getSelectedItem();


        if(leitorSelecionado == null){
            JOptionPane.showMessageDialog(null, "Selecione um leitor para editar");
        }else{
            invoker.invoke("editarLeitor", leitorSelecionado);
        }
    }
    
    
    @FXML
    protected void btExcluirLeitor(ActionEvent e) throws Exception{
        LeitorModel leitorSelecionado = leitoresTableView.getSelectionModel().getSelectedItem();


        if(leitorSelecionado == null){
            JOptionPane.showMessageDialog(null, "Selecione um leitor para editar");
        }else{
            invoker.invoke("excluirLeitor", leitorSelecionado);
            Main.changeScreen("leitores");
        }
    }

    @FXML
    public void initialize() {

        invoker.register("editarLeitor", new EditarLeitorCommand());
        invoker.register("excluirLeitor", new ExcluirLeitorCommand());
        
        

        // Coluna para Nome Completo usando getNomeCompleto
        TableColumn<LeitorModel, String> colNomeCompleto = new TableColumn<>("Nome Completo");
        colNomeCompleto.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().getNomeCompleto()));

        // Coluna para CPF
        TableColumn<LeitorModel, String> colCpf = new TableColumn<>("CPF");
        colCpf.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().getCpf()));

        // Coluna para Telefone Um
        TableColumn<LeitorModel, String> colTelefoneUm = new TableColumn<>("Telefone Um");
        colTelefoneUm.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().getTelefoneUm()));

        // Coluna para Telefone Dois
        TableColumn<LeitorModel, String> colTelefoneDois = new TableColumn<>("Telefone Dois");
        colTelefoneDois.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().getTelefoneDois()));

        // Coluna para Número
        TableColumn<LeitorModel, Integer> colNumero = new TableColumn<>("Número");
        colNumero.setCellValueFactory(data -> new SimpleIntegerProperty(
                data.getValue().getNumero()).asObject());

        // Coluna para Endereço usando getEndereco
        TableColumn<LeitorModel, String> colEndereco = new TableColumn<>("Endereço");
        colEndereco.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().getEndereco()));

        // Adicionando as colunas à TableView
        leitoresTableView.getColumns().addAll(colNomeCompleto, colCpf, colTelefoneUm, colTelefoneDois, colEndereco,
                colNumero);

        // Obtendo a lista de leitores e preenchendo a TableView
        atualizarTabela();
    }

    public void atualizarTabela() {
        List<LeitorModel> leitores = leitoresController.pegarLeitores();
        preencherTableViewLeitor(leitores);
    }

    @FXML
    protected void btBuscarLeitorPorNome(ActionEvent event) {
        String nome = txtLeitorPesquisado.getText();
        List<LeitorModel> leitores = leitoresController.buscarLeitorPorNome(nome);
        preencherTableViewLeitor(leitores);
    }

    public void preencherTableViewLeitor(List<LeitorModel> leitores) {
        ObservableList<LeitorModel> leitoresObservableList = FXCollections.observableArrayList(leitores);
        leitoresTableView.setItems(leitoresObservableList);
    }

}
