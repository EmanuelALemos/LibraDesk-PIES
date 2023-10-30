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
    private static Scene Leitores;
    private static Scene Emprestimos;
    private static Scene Em_Atraso;
    
    @Override
    public void start(Stage primaryStage)throws Exception{
        stage = primaryStage;
        primaryStage.setTitle("LibraDesk");
        
        //fazendo o carregamento dos arquivos fxml
        Parent xmlAcervo = FXMLLoader.load(getClass().getResource("../view/Acervo.fxml"));
        Parent xmlLeitores = FXMLLoader.load(getClass().getResource("../view/Leitores.fxml"));
        Parent xmlEmprestimos = FXMLLoader.load(getClass().getResource("../view/Emprestimo.fxml"));
        Parent xmlEm_Atraso = FXMLLoader.load(getClass().getResource("../view/Em_Atraso.fxml"));

        //criando as cenas
        Acervo = new Scene(xmlAcervo, 1280,720);
        Acervo.getStylesheets().add(getClass().getResource("../libradesk/style.css").toExternalForm());
        
        Leitores = new Scene(xmlLeitores, 1280,720);
        Leitores.getStylesheets().add(getClass().getResource("../libradesk/style.css").toExternalForm());

        Emprestimos = new Scene(xmlEmprestimos, 1280,720);
        Emprestimos.getStylesheets().add(getClass().getResource("../libradesk/style.css").toExternalForm());

        Em_Atraso = new Scene(xmlEm_Atraso, 1280,720);
        Em_Atraso.getStylesheets().add(getClass().getResource("../libradesk/style.css").toExternalForm());

        //definindo a cena inicial
        primaryStage.setScene(Acervo);
        primaryStage.show();
    }
    
    public static void changeScreen(String src){
        switch (src){
            case "acervo":
                stage.setScene(Acervo);
                break;
            case "leitores":
                stage.setScene(Leitores);
                break;
            case "emprestimos":
                stage.setScene(Emprestimos);
                break;
            case "em_atraso":
                stage.setScene(Em_Atraso);
                break;
        }
    }
    public static void main(String[] args ) {
        launch(args);
    }
    
}
