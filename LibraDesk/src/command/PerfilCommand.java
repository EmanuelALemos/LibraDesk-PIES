package command;

import controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class PerfilCommand implements Command{
    public void execute() throws Exception{
        Parent xmlPerfil = FXMLLoader.load(getClass().getResource("../screens/fxml/Perfil.fxml"));
        Scene Perfil = new Scene(xmlPerfil, 1280, 720);
        Perfil.getStylesheets().add(getClass().getResource("../screens/css/style.css").toExternalForm());
        Main.changeScene(Perfil);
    }
}
