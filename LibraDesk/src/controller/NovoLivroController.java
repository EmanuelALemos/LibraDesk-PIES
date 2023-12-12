/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
*/
package controller;


import DAO.AcervoDAO;


/**
 * FXML Controller class
 *
 * @author arauj
 */
public class NovoLivroController implements IController {

    AcervoDAO acervoDAO = new AcervoDAO();

    // A conexão com o banco de dados


    public void cadastrarLivro(String titulo, String localBiblioteca, int numeroExemplares, String autor){
        acervoDAO.adicionarLivro(titulo, localBiblioteca, numeroExemplares, autor); 
    }

    

}
