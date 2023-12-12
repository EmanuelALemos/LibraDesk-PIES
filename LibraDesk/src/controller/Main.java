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
import command.*;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.scene.Node;


public class Main extends Application{

    private static Stage stage;
    private static Invoker invoker = new Invoker();
    
    @Override
    public void start(Stage primaryStage)throws Exception{

        stage = primaryStage;
        primaryStage.setTitle("LibraDesk");

        invoker.register("login", new LoginCommand());
        invoker.register("acervo", new AcervoCommand());
        invoker.register("leitores", new LeitoresCommand());
        invoker.register("emprestimos", new EmprestimosCommand());
        invoker.register("em_atraso", new EmAtrasoCommand());
        invoker.register("novoUsuario", new CadastrarUsuarioCommand());
        invoker.register("perfil", new PerfilCommand());
        invoker.register("funcionario", new FuncionariosCommand());
        invoker.register("novoLivro", new NovoLivroCommand());
        invoker.register("novoLeitor", new NovoLeitorCommand());
        invoker.register("novoEmprestimo", new NovoEmprestimoCommand());
        invoker.register("confirmarPopUp", new ConfirmarPopUpCommand());
        invoker.invoke("login");
        primaryStage.show();
    }
    
    public static void changeScreen(String src) throws Exception {
        invoker.invoke(src);
    }

    public static void changeScene(Scene scene) {
        stage.setScene(scene);
    }
    
    public static void main(String[] args ) {
        launch(args);

    }
    
}
