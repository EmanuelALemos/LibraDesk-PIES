 package screens.view;


import controller.Main;
import controller.NovoLeitorController;
import model.LeitorModel;
import model.PessoaModel;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class NovoLeitorView {
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
    public void btCadastrarLeitor(ActionEvent e) throws Exception  {
        NovoLeitorController novoLeitorController = new NovoLeitorController();
        
        String nomeCompleto = nomeLeitor.getText();
        String[] partesNome = nomeCompleto.split(" ", 2);
        String primeiroNome = partesNome[0];
        String sobrenome = (partesNome.length > 1) ? partesNome[1] : null;

        novoLeitorController.adicionarPessoa(primeiroNome, sobrenome, cpfLeitor.getText());
        novoLeitorController.adicionarLeitor(
                telefone1Leitor.getText(),
                telefone2Leitor.getText(),
                cpfLeitor.getText(),
                bairroLeitor.getText(),
                ruaLeitor.getText(),
                cidadeLeitor.getText(),
                Integer.parseInt(numeroLeitor.getText()));
    
        Main.changeScreen("leitores");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void btCancelarLeitor(ActionEvent e) throws Exception  {
        Main.changeScreen("leitores");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

    
}