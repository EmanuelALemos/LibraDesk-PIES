package command;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import controller.Main;

public class FuncionariosCommand implements Command{
    public void execute() throws Exception{
        Parent xmlFuncionarios = FXMLLoader.load(getClass().getResource("../screens/fxml/Funcionarios.fxml"));
        Scene Funcionarios = new Scene(xmlFuncionarios, 1280, 720);
        Funcionarios.getStylesheets().add(getClass().getResource("../screens/css/style.css").toExternalForm());
        Main.changeScene(Funcionarios);
    }
}
