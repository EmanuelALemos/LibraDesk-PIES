/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller; 

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    private static Stage stage;
    
    private static Scene Acervo;
    private static Scene NovoLivro;
    
    @Override
    public void start(Stage primaryStage)throws Exception{
        
        stage = primaryStage;
        primaryStage.setTitle("LibraDesk");
        
        Parent xmlAcervo = FXMLLoader.load(getClass().getResource("../view/Acervo.fxml"));
        Acervo = new Scene(xmlAcervo, 1280,720);
        
        Parent fxmlNovoLivro = FXMLLoader.load(getClass().getResource("../view/NovoLivro.fxml"));
        NovoLivro = new Scene(fxmlNovoLivro, 992,614);
        
        primaryStage.setScene(Acervo);
        primaryStage.show();
    }
    
    public static void changeScreen(String src){
        if(src.equals("acervo")){
                stage.setScene(Acervo);
        }
        else if(src.equals("novoLivro")){
                stage.setScene(NovoLivro);
        }
    }
    public static void main(String[] args ) {
        launch(args);
    }
    
}
