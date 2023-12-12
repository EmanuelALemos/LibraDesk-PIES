package screens.view;

import javafx.scene.Node;
import controller.LeitoresController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ConfirmarExcluirLeitorView {
    LeitoresController leitoresController = new LeitoresController();
    String cpfLeitor;
    
    public void setCpfLeitor(String cpfLeitor) {
        this.cpfLeitor = cpfLeitor;
    }

    @FXML
    protected void btConfirmar(ActionEvent e){
        leitoresController.excluirLeitor(cpfLeitor);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void btCancelar(ActionEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }   
}
