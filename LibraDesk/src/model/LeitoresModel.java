package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gabri
 */
public class LeitoresModel {
    private String nome;
    private String telefoneUm;
    private String telefoneDois;
    private String cpf;
    private String bairro;
    private String rua;
    private String cidade;
    private String numero;

    // Construtor
    public LeitoresModel(String nome, String telefoneUm, String telefoneDois, String cpf,
                         String bairro, String rua, String cidade, String numero) {
        this.nome = nome;
        this.telefoneUm = telefoneUm;
        this.telefoneDois = telefoneDois;
        this.cpf = cpf;
        this.bairro = bairro;
        this.rua = rua;
        this.cidade = cidade;
        this.numero = numero;
    }

    // Métodos Getter
    public String getNome() {
        return nome;
    }

    public String getTelefoneUm() {
        return telefoneUm;
    }

    public String getTelefoneDois() {
        return telefoneDois;
    }

    public String getCpf() {
        return cpf;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getNumero() {
        return numero;
    }

    // Métodos Setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefoneUm(String telefoneUm) {
        this.telefoneUm = telefoneUm;
    }

    public void setTelefoneDois(String telefoneDois) {
        this.telefoneDois = telefoneDois;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
