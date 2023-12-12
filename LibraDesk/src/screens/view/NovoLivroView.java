package screens.view;

import javafx.stage.Stage;
import javafx.scene.Node;

import controller.Main;
import controller.NovoLivroController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.LivroModel;

public class NovoLivroView {

    NovoLivroController novoLivroController = new NovoLivroController();

    @FXML
    private TextField tituloLivro;
    @FXML
    private TextField autorLivro;
    @FXML
    private TextField localizacaoLivro;
    @FXML
    private TextField numExemplaresLivro;
    

    @FXML
    public void BtCadastrar(ActionEvent e) throws Exception  {
        
        novoLivroController.cadastrarLivro(tituloLivro.getText(), localizacaoLivro.getText(),
                Integer.parseInt(numExemplaresLivro.getText()), autorLivro.getText());

        Main.changeScreen("acervo");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();

    }

    @FXML
    public void btCancelar(ActionEvent e) throws Exception {
        Main.changeScreen("acervo");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }
}
