/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;


import DAO.LeitoresDAO;


/**
 * FXML Controller class
 *
 * @author arauj
 */
public class NovoLeitorController implements IController {

    LeitoresDAO leitoresDAO = new LeitoresDAO();

    public void adicionarPessoa(String pnome, String sobrenome, String cpf) {
        leitoresDAO.adicionarPessoa(pnome, sobrenome, cpf);
    }

    public void adicionarLeitor(String telefoneUm, String telefoneDois, String cpf, String bairro, String rua,
            String cidade, int numero) {
        leitoresDAO.adicionarLeitor(telefoneUm, telefoneDois, cpf, bairro, rua, cidade, numero);
    }

}
