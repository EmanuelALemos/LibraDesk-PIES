package screens.view;

import java.util.Date;
import java.util.List;


import controller.Main;
import controller.NovoEmprestimoController;
import model.EmprestimoModel;
import controller.EmprestimosController;
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

public class EmprestimosView {

    EmprestimosController emprestimoController = new EmprestimosController();

    @FXML
    protected void btLeitores(ActionEvent e)throws Exception  {
        Main.changeScreen("leitores");
    }

    @FXML
    protected void btAcervo(ActionEvent e) throws Exception {
        Main.changeScreen("acervo");
    }

    @FXML
    protected void btEmAtraso(ActionEvent e)throws Exception  {
        Main.changeScreen("em_atraso");
    }

    @FXML
    protected void btNovoEmprestimo(ActionEvent e) throws Exception {
        Main.changeScreen("novoEmprestimo");
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
    private TableView<EmprestimoModel> emprestimosTableView;

    @FXML
    private MenuButton btOpcaoBusca;

    @FXML
    private TextField txtCampoPesquisado;

    

    
    @FXML
    public void initialize() {

        MenuItem item1 = new MenuItem("Por leitor");
        MenuItem item2 = new MenuItem("Por titulo");

        item1.setOnAction(event -> handleOpcaoSelecionada(item1));
        item2.setOnAction(event -> handleOpcaoSelecionada(item2));

        btOpcaoBusca.getItems().addAll(item1, item2);

        TableColumn<EmprestimoModel, Integer> colIdEmprestimo = new TableColumn<>("Nº");
        colIdEmprestimo
                .setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getIdEmprestimo()).asObject());

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

        TableColumn<EmprestimoModel, String> colStatus = new TableColumn<>("Status");
        colStatus.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStatus()));

        emprestimosTableView.getColumns().addAll(colIdEmprestimo, colNomeLeitor, colCpfLeitor, colNomeLivro,
                colDataEmprestimo, colDataPrevDevolucao, colMulta, colStatus);
        emprestimoController.atualizarMultas();
        atualizarTabela();

    }

    public void atualizarTabela() {
        List<EmprestimoModel> emprestimos = emprestimoController.pegarEmprestimos();
        preencherTableViewEmprestimo(emprestimos);
    }

    public void preencherTableViewEmprestimo(List<EmprestimoModel> emprestimos) {
        ObservableList<EmprestimoModel> emprestimosObservableList = FXCollections.observableArrayList(emprestimos);
        emprestimosTableView.setItems(emprestimosObservableList);
    }

    private String getOpcaoBusca() {
        return btOpcaoBusca.getText();
    }

    @FXML
    protected void btBuscarEmprestimo(ActionEvent e) {
        System.out.println("bt");
        List<EmprestimoModel> emprestimos = emprestimoController.buscarEmprestimo( getOpcaoBusca(), txtCampoPesquisado.getText());
        if(emprestimos != null) preencherTableViewEmprestimo(emprestimos);
    }

    private void handleOpcaoSelecionada(MenuItem menuItem) {
        // Atualiza o texto do MenuButton com o texto do item selecionado
        btOpcaoBusca.setText(menuItem.getText());
    }

    @FXML
    protected void btDebitarEmprestimo(ActionEvent e) throws Exception {
        EmprestimoModel emprestimoSelecionado = emprestimosTableView.getSelectionModel().getSelectedItem();
        emprestimoController.debitarEmprestimo(emprestimoSelecionado.getIdEmprestimo());
        Main.changeScreen("emprestimos");
       
    }
}
