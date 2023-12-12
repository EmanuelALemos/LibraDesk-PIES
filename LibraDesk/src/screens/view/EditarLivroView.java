package screens.view;

import controller.EditarLivroController;
import controller.Main;
import model.LivroModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class EditarLivroView {

    EditarLivroController editarLivroController = new EditarLivroController();

    @FXML
    private TextField tituloLivro;
    @FXML
    private TextField autorLivro;
    @FXML
    private TextField localizacaoLivro;
    @FXML
    private TextField numExemplaresLivro;

    int idLivro;

    @FXML
    public void btEditarLivro(ActionEvent e) throws Exception {
        String titulo = tituloLivro.getText();
        String autor = autorLivro.getText();
        String localizacao = localizacaoLivro.getText();
        int numExemplares = Integer.parseInt(numExemplaresLivro.getText());

        editarLivroController.EditarLivro(titulo, localizacao, numExemplares, autor, idLivro);
        Main.changeScreen("acervo");
    }

    public void preencherCampos(LivroModel livro) {

        String titulo = livro.getTitulo();
        String autor = livro.getAutor();
        String localizacao = String.valueOf(livro.getLocalBiblioteca());
        String numExemplares = String.valueOf(livro.getNumeroExemplares());
        
        tituloLivro.setText(livro.getTitulo());
        autorLivro.setText(livro.getAutor());
        localizacaoLivro.setText(String.valueOf(livro.getLocalBiblioteca()));
        numExemplaresLivro.setText(String.valueOf(livro.getNumeroExemplares()));
        idLivro = livro.getId();
    }

    @FXML
    public void btCancelar(ActionEvent e) throws Exception {
        Main.changeScreen("acervo");
    }
}
