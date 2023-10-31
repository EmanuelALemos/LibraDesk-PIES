/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller; 


import conexaoDAO.Conexao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;

public class Main extends Application{

    private static Stage stage;
    
    private static Scene Acervo;
    private static Scene NovoLivro;
    
    @Override
    public void start(Stage primaryStage)throws Exception{
        stage = primaryStage;
        primaryStage.setTitle("LibraDesk");
        
        Parent xmlEntrar = FXMLLoader.load(getClass().getResource("../view/NovoLivro.fxml"));
        Acervo = new Scene(xmlEntrar, 1280,720);
        Acervo.getStylesheets().add(getClass().getResource("../libradesk/style.css").toExternalForm());
        
        Parent fxmlNovoLivro = FXMLLoader.load(getClass().getResource("../view/NovoLivro.fxml"));
        NovoLivro = new Scene(fxmlNovoLivro, 992,614);
        
        primaryStage.setScene(Acervo);
        primaryStage.show();
    }
    
    public static void changeScreen(String src){
        switch (src){
            case "acervo":
                stage.setScene(Acervo);
                break;
            case "novoLivro":
                stage.setScene(NovoLivro);
                break;
        }
    }
    public static void main(String[] args ) {
        launch(args);

    }
    
}
