/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import DAO.LoginDAO;

/**
 * FXML Controller class
 *
 * @author CAIO
 */
public class LoginController implements IController {
    LoginDAO loginDAO = new LoginDAO();

    public boolean validarCampos(String login, String senha) {
        return loginDAO.validarCampos(login, senha);
    }
   
}
