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
    private Date dataEmprestimo;
    private Date dataPrevDev;
    private Date dataRealDev;
    private double multa;
    private String cpfLeitor;
    private int idLivro;
    private boolean status;

    // Construtor
    public EmprestimoModel(Date dataEmprestimo, Date dataPrevDev, Date dataRealDev, double multa, String cpfLeitor, int idLivro, boolean status) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevDev = dataPrevDev;
        this.dataRealDev = dataRealDev;
        this.multa = multa;
        this.cpfLeitor = cpfLeitor;
        this.idLivro = idLivro;
        this.status = status;
    }

    // Getters
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

    public int getIdLivro() {
        return idLivro;
    }

    public boolean isStatus() {
        return status;
    }

    // Setters
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

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

