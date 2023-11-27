package model;

import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gabri
 */
import java.util.Date;

public class EmprestimoModel {
    private String nomeLeitor;
    private Date dataEmprestimo;
    private Date dataPrevDev;
    private Date dataRealDev;
    private double multa;
    private String cpfLeitor;
    private String nomeLivro;
    private int idLivro;
    private boolean status;
    private int idEmprestimo;

    // Construtor
    public EmprestimoModel(String nomeLeitor, Date dataEmprestimo, Date dataPrevDev, Date dataRealDev, double multa, String cpfLeitor, String nomeLivro, int idLivro, boolean status, int idEmprestimo) {
        this.nomeLeitor = nomeLeitor;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevDev = dataPrevDev;
        this.dataRealDev = dataRealDev;
        this.multa = multa;
        this.cpfLeitor = cpfLeitor;
        this.nomeLivro = nomeLivro;
        this.idLivro = idLivro;
        this.status = status;
        this.idEmprestimo = idEmprestimo;
    }

    // Getters
    public String getNomeLeitor(){
        return nomeLeitor;
    }
    
    
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Date getDataPrevDev() {
        return dataPrevDev;
    }

    public Date getDataRealDev() {
        return dataRealDev;
    }

    public double getMulta() {
        return multa;
    }

    public String getCpfLeitor() {
        return cpfLeitor;
    }
    
    public String getNomeLivro(){
        return nomeLivro;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public boolean isStatus() {
        return status;
    }
    
    public String getStatus(){
        if(status){
            return "Emprestado";
        }else{
            return "Livre";
        }
    }
    
    public int getIdEmprestimo(){
        return idEmprestimo;
    }

    // Setters
    public void setNomeLeitor(String nomeLeitor){
        this.nomeLeitor = nomeLeitor;
    } 
    
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataPrevDev(Date dataPrevDev) {
        this.dataPrevDev = dataPrevDev;
    }

    public void setDataRealDev(Date dataRealDev) {
        this.dataRealDev = dataRealDev;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public void setCpfLeitor(String cpfLeitor) {
        this.cpfLeitor = cpfLeitor;
    }
    
    public void setNomeLivro(String nomeLivro){
        this.nomeLivro = nomeLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void setIdEmprestimo(int idEmprestimo){
        this.idEmprestimo = idEmprestimo;
    }
}

