package command;

import controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class CadastrarUsuarioCommand implements Command{
    public void execute() throws Exception{
        Parent xmlCadastrarUsuario = FXMLLoader.load(getClass().getResource("../screens/fxml/CadastrarUsuario.fxml"));
        Scene CadastrarUsuario = new Scene(xmlCadastrarUsuario, 1280, 720);
        CadastrarUsuario.getStylesheets().add(getClass().getResource("../screens/css/styleEntrar.css").toExternalForm());
        Main.changeScene(CadastrarUsuario);
    }
}
