package command;

import controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LeitoresCommand implements Command{
    public void execute() throws Exception{
        Parent xmlLeitores = FXMLLoader.load(getClass().getResource("../screens/fxml/Leitores.fxml"));
        Scene Leitores = new Scene(xmlLeitores, 1280, 720);
        Leitores.getStylesheets().add(getClass().getResource("../screens/css/style.css").toExternalForm());
        Main.changeScene(Leitores);
    }
}
