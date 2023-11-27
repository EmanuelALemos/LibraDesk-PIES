/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.util.Date;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.LivroModel;
import model.EmprestimoModel;

/**
 * FXML Controller class
 *
 * @author CAIO
 */
public class EmprestimosController {

    @FXML
    protected void btLeitores(ActionEvent e) {
        Main.changeScreen("leitores");
    }

    @FXML
    protected void btAcervo(ActionEvent e) {
        Main.changeScreen("acevo");
    }

    @FXML
    protected void btEmAtraso(ActionEvent e) {
        Main.changeScreen("em_atraso");
    }

    @FXML
    protected void btNovoEmprestimo(ActionEvent e) {
        openNovoEmprestimoPopup();
    }

    @FXML
    private TableView<EmprestimoModel> emprestimosTableView;
    
    @FXML
    private MenuButton btOpcaoBusca;
    
    @FXML
    private TextField txtCampoPesquisado;
    

    private static void openNovoEmprestimoPopup() {
        try {
            // Carregando o arquivo FXML da tela NovoLivro
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/NovoEmprestimo.fxml"));
            Parent root = loader.load();

            // Criando um novo palco (Stage) para a tela NovoLivro
            Stage novoEmprestimoStage = new Stage();
            novoEmprestimoStage.setTitle("Novo Livro");
            novoEmprestimoStage.initStyle(StageStyle.UTILITY);
            novoEmprestimoStage.initModality(Modality.APPLICATION_MODAL);
            novoEmprestimoStage.setScene(new Scene(root, 992, 614));

            // Exibindo o palco
            novoEmprestimoStage.showAndWait();
        } catch (Exception e) {
            // Tratamento de exceção (substitua por um tratamento adequado)
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        
        MenuItem item1 = new MenuItem("Por leitor");
        MenuItem item2 = new MenuItem("Por titulo");
        
        item1.setOnAction(event -> handleOpcaoSelecionada(item1));
        item2.setOnAction(event -> handleOpcaoSelecionada(item2));

        btOpcaoBusca.getItems().addAll(item1, item2);
        
        TableColumn<EmprestimoModel, String> colNomeLeitor = new TableColumn<>("Nome Leitor");
        colNomeLeitor.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNomeLeitor()));

        TableColumn<EmprestimoModel, String> colCpfLeitor = new TableColumn<>("CPF Leitor");
        colCpfLeitor.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCpfLeitor()));

        TableColumn<EmprestimoModel, String> colNomeLivro = new TableColumn<>("Nome Livro");
        colNomeLivro.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNomeLivro()));

        TableColumn<EmprestimoModel, Date> colDataEmprestimo = new TableColumn<>("Data Empréstimo");
        colDataEmprestimo.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDataEmprestimo()));

        TableColumn<EmprestimoModel, Date> colDataPrevDevolucao = new TableColumn<>("Data Devolução Prevista");
        colDataPrevDevolucao.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDataPrevDev()));

        TableColumn<EmprestimoModel, Double> colMulta = new TableColumn<>("Multa");
        colMulta.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getMulta()));

        TableColumn<EmprestimoModel, Boolean> colStatus = new TableColumn<>("Status");
        colStatus.setCellValueFactory(data -> new SimpleBooleanProperty(data.getValue().isStatus()));
        
        emprestimosTableView.getColumns().addAll(colNomeLeitor, colCpfLeitor, colNomeLivro, colDataEmprestimo, colDataPrevDevolucao, colMulta, colStatus);

    }
    
    private String getOpcaoBusca(){
        return btOpcaoBusca.getText();
    }
    
    @FXML
    protected void btBuscarEmprestimo(ActionEvent action){
        if(getOpcaoBusca() == "Opção Busca"){
            
        }else{
            if(getOpcaoBusca() == "Por leitor"){
                
            }else{
            
            }
            
        }
    
    }
    
    public void buscarEmprestimoPorLeitor(){
    
        try{
            String sql = "SELECT * FROM emprestimo"
        }catch(){
        
        
        }
    }
    
    
    private void handleOpcaoSelecionada(MenuItem menuItem) {
        // Atualiza o texto do MenuButton com o texto do item selecionado
        btOpcaoBusca.setText(menuItem.getText());
        
    }
    
    

}
