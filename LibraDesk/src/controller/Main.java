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
import javafx.stage.Modality;
import javafx.stage.StageStyle;

public class Main extends Application{

    private static Stage stage;
    
    private static Scene Login;
    private static Scene Acervo;
    private static Scene Leitores;
    private static Scene Emprestimos;
    private static Scene Em_Atraso;
    private static Scene NovoLivro;
    
    @Override
    public void start(Stage primaryStage)throws Exception{
        stage = primaryStage;
        primaryStage.setTitle("LibraDesk");
        
        //fazendo o carregamento dos arquivos fxml
        Parent xmlLogin = FXMLLoader.load(getClass().getResource("../view/Entrar.fxml"));
        Parent xmlAcervo = FXMLLoader.load(getClass().getResource("../view/Acervo.fxml"));
        Parent xmlLeitores = FXMLLoader.load(getClass().getResource("../view/Leitores.fxml"));
        Parent xmlEmprestimos = FXMLLoader.load(getClass().getResource("../view/Emprestimo.fxml"));
        Parent xmlEm_Atraso = FXMLLoader.load(getClass().getResource("../view/Em_Atraso.fxml"));

        //criando as cenas
        Login = new Scene(xmlLogin, 1280,720);
        Login.getStylesheets().add(getClass().getResource("../libradesk/style.css").toExternalForm());

        Acervo = new Scene(xmlAcervo, 1280,720);
        Acervo.getStylesheets().add(getClass().getResource("../libradesk/style.css").toExternalForm());
        
        Leitores = new Scene(xmlLeitores, 1280,720);
        Leitores.getStylesheets().add(getClass().getResource("../libradesk/style.css").toExternalForm());

        Emprestimos = new Scene(xmlEmprestimos, 1280,720);
        Emprestimos.getStylesheets().add(getClass().getResource("../libradesk/style.css").toExternalForm());

        Em_Atraso = new Scene(xmlEm_Atraso, 1280,720);
        Em_Atraso.getStylesheets().add(getClass().getResource("../libradesk/style.css").toExternalForm());

        //definindo a cena inicial
        primaryStage.setScene(Login);
        primaryStage.show();
    }
    
    public static void changeScreen(String src){
        // stage.setScene(newScene);
        switch (src){
            case "login":
                stage.setScene(Login);
                break;
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
    
    // private static void openNovoLivroPopup() {
    //     try {
    //         // Carregando o arquivo FXML da tela NovoLivro
    //         FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/NovoLivro.fxml"));
    //         Parent root = loader.load();

    //         // Criando um novo palco (Stage) para a tela NovoLivro
    //         Stage novoLivroStage = new Stage();
    //         novoLivroStage.setTitle("Novo Livro");
    //         novoLivroStage.initStyle(StageStyle.UTILITY);
    //         novoLivroStage.initModality(Modality.APPLICATION_MODAL);
    //         novoLivroStage.setScene(new Scene(root, 992, 614));

    //         // Exibindo o palco
    //         novoLivroStage.showAndWait();
    //     } catch (Exception e) {
    //         // Tratamento de exceção (substitua por um tratamento adequado)
    //         e.printStackTrace();
    // }
    // }
    
    public static void main(String[] args ) {
        launch(args);

    }
    
}
