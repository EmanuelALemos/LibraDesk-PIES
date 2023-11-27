/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author gabri
 */
public class LivroModel {
    private String titulo;
    private int id;
    private String localBiblioteca;
    private int numeroExemplares;
    private String autor;

    // Construtor
    public LivroModel(String titulo, int id, String localBiblioteca, int numeroExemplares, String autor) {
        this.titulo = titulo;
        this.id = id;
        this.localBiblioteca = localBiblioteca;
        this.numeroExemplares = numeroExemplares;
        this.autor = autor;
    }

    public LivroModel() {

    }

    // Métodos Get
    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    public String getLocalBiblioteca() {
        return localBiblioteca;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumeroExemplares() {
        return numeroExemplares;
    }

    // Métodos Set
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocalBiblioteca(String localBiblioteca) {
        this.localBiblioteca = localBiblioteca;
    }

    public void setNumeroExemplares(int numeroExemplares) {
        this.numeroExemplares = numeroExemplares;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
