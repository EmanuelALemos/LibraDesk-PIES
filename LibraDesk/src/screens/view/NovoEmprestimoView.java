package screens.view;


import controller.Main;
import controller.NovoEmprestimoController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.EmprestimoModel;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javafx.stage.Stage;


public class NovoEmprestimoView {

    NovoEmprestimoController novoEmprestimoController = new NovoEmprestimoController();

    @FXML
    private TextField nomeLeitorEmprestimo;
    @FXML
    private TextField cpfLeitorEmprestimo;
    @FXML
    private TextField livroEmprestimo;
    @FXML
    private TextField dataEmprestimo;
    @FXML
    private TextField dataDevolucao;

    @FXML
    public void btCadastrarEmprestimo(ActionEvent e) throws Exception {

        novoEmprestimoController.adicionarEmprestimo(
         parseDate(dataEmprestimo.getText()), parseDate(dataDevolucao.getText()),
           0, cpfLeitorEmprestimo.getText(), livroEmprestimo.getText(), 0);
        

        Main.changeScreen("emprestimos");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void btCancelarEmprestimo(ActionEvent e) throws Exception {
        Main.changeScreen("emprestimos");
    }
    
    private Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            // Em caso de erro na conversão
            e.printStackTrace(); // Trate o erro de acordo com sua necessidade
            return null; // Ou lance uma exceção, dependendo do seu fluxo de controle
        }
    }
}
