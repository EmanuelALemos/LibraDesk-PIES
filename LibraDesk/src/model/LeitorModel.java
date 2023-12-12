package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gabri
 */
public class LeitorModel extends PessoaModel{
    private String telefoneUm;
    private String telefoneDois;
    private String bairro;
    private String rua;
    private String cidade;
    private int numero;

    // Construtor
    public LeitorModel(String pnome, String sobrenome, String cpf, String telefoneUm, String telefoneDois,
            String bairro, String rua, String cidade, int numero) {
        super(pnome, sobrenome, cpf);
        this.telefoneUm = telefoneUm;
        this.telefoneDois = telefoneDois;
        this.bairro = bairro;
        this.rua = rua;
        this.cidade = cidade;
        this.numero = numero;
    }

    public String getTelefoneUm() {
        return telefoneUm;
    }

    public String getTelefoneDois() {
        return telefoneDois;
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

    public int getNumero() {
        return numero;
    }

    public String getEndereco() {
        return cidade + ", " + bairro + ", " + rua;
    }

    public void setTelefoneUm(String telefoneUm) {
        this.telefoneUm = telefoneUm;
    }

    public void setTelefoneDois(String telefoneDois) {
        this.telefoneDois = telefoneDois;
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

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
