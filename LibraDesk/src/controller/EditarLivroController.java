/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.LivroModel;

/**
 *
 * @author gabri
 */
public class EditarLivroController {
    
    @FXML
    private TextField tituloLivro;
    @FXML
    private TextField autorLivro;
    @FXML
    private TextField localizacaoLivro;
    @FXML
    private TextField numExemplaresLivro;
    
    public void preencherCampos(LivroModel livro){
        tituloLivro.setText(livro.getTitulo());
        autorLivro.setText(livro.getAutor());
        localizacaoLivro.setText(livro.getLocalBiblioteca());    
        numExemplaresLivro.setText(String.valueOf(livro.getNumeroExemplares()));
    }
    
    
}
