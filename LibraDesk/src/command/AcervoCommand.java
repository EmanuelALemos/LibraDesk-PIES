package command;

import controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class AcervoCommand implements Command{
    public void execute() throws Exception{
        Parent xmlAcervo = FXMLLoader.load(getClass().getResource("../screens/fxml/Acervo.fxml"));
        Scene Acervo = new Scene(xmlAcervo, 1280, 720);
        Acervo.getStylesheets().add(getClass().getResource("../screens/css/style.css").toExternalForm());
        Main.changeScene(Acervo);
    }
}
