/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author gabri
 */
public class PessoaModel {
    private String pnome;
    private String sobrenome;
    private String cpf;

    // Construtor
    public PessoaModel(String pnome, String sobrenome, String cpf) {
        this.pnome = pnome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    // Métodos Getter
    public String getPnome() {
        return pnome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }


    public String getNomeCompleto() {
        return pnome + " " + sobrenome;
    }

    // Métodos Setter
    public void setPnome(String pnome) {
        this.pnome = pnome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
