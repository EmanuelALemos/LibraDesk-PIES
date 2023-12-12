package screens.view;

import javafx.stage.Stage;
import javafx.scene.Node;
import controller.EditarLeitorController;
import controller.Main;
import model.LeitorModel;
import model.PessoaModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class EditarLeitorView {

    EditarLeitorController editarLeitorController = new EditarLeitorController();
    
    @FXML
    private TextField nomeLeitor;
    @FXML
    private TextField cpfLeitor;
    @FXML
    private TextField telefone1Leitor;
    @FXML
    private TextField telefone2Leitor;
    @FXML
    private TextField cidadeLeitor;
    @FXML
    private TextField bairroLeitor;
    @FXML
    private TextField ruaLeitor;
    @FXML
    private TextField numeroLeitor;

    @FXML
    public void btEditarLeitor(ActionEvent e) throws Exception {
        String nomeCompleto = nomeLeitor.getText();
        String[] partesNome = nomeCompleto.split(" ", 2);
        String primeiroNome = partesNome[0];
        String sobrenome = (partesNome.length > 1) ? partesNome[1] : null;
        
        editarLeitorController.editarPessoa(primeiroNome, sobrenome, cpfLeitor.getText());
        editarLeitorController.editarLeitor(telefone1Leitor.getText(), telefone2Leitor.getText(), cpfLeitor.getText(), bairroLeitor.getText(), ruaLeitor.getText(), cidadeLeitor.getText(), Integer.parseInt(numeroLeitor.getText()));
        Main.changeScreen("leitores");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void btCancelarLeitor(ActionEvent e) throws Exception {
        Main.changeScreen("leitores");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

    public void preencherCampos(LeitorModel leitor){
        nomeLeitor.setText(leitor.getNomeCompleto());
        cpfLeitor.setText(leitor.getCpf());
        telefone1Leitor.setText(leitor.getTelefoneUm());
        telefone2Leitor.setText(leitor.getTelefoneDois());
        ruaLeitor.setText(leitor.getRua());
        cidadeLeitor.setText(leitor.getCidade());
        bairroLeitor.setText(leitor.getBairro());
        numeroLeitor.setText(String.valueOf(leitor.getNumero()));
    }
}
