package screens.view;

import java.util.List;

import controller.ConfirmarCadastroController;
import controller.FuncionarioController;
import controller.Main;
import model.BibliotecariaModel;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.EmprestimoModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class FuncionariosView {
    FuncionarioController  funcionarioController = new FuncionarioController();

    @FXML
    private TableView<BibliotecariaModel> TableViewFuncionario;

    @FXML
    protected void btVoltar(ActionEvent e) throws Exception {
        Main.changeScreen("acervo");
    }
    
    @FXML
    protected void btSair(ActionEvent e) throws Exception {
        Main.changeScreen("login");
    }
    
    
    
    @FXML
    public void initialize(){
        TableColumn<BibliotecariaModel, String> colNome = new TableColumn<>("Funcionário");
        colNome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNomeCompleto()));

        TableColumn<BibliotecariaModel, String> colCargo = new TableColumn<>("Cargo");
        colCargo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().cargoCoordenador()));

        TableColumn<BibliotecariaModel, String> colCpf = new TableColumn<>("CPF");
        colCpf.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCpf()));

        TableViewFuncionario.getColumns().addAll(colNome, colCargo, colCpf);
        atualizarTabela();
    }

    public void atualizarTabela(){
        List<BibliotecariaModel> listaBibliotecaria = funcionarioController.getFuncionarios();
        preencherTableView(listaBibliotecaria);
    }

    public void excluirFuncionario() throws Exception{
        System.out.println("Entrou no excluir na view");
        BibliotecariaModel bibliotecaria = TableViewFuncionario.getSelectionModel().getSelectedItem();
        funcionarioController.excluirFuncionario(bibliotecaria.getCpf());
        atualizarTabela();
        Main.changeScreen("funcionarios");
    }

    public void preencherTableView(List<BibliotecariaModel> listaBibliotecaria){       
        ObservableList<BibliotecariaModel> observableListBibliotecaria = FXCollections.observableArrayList(listaBibliotecaria);
        TableViewFuncionario.setItems(observableListBibliotecaria);
    }
     
}
