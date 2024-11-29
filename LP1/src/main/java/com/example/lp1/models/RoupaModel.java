package com.example.lp1.models;

public class RoupaModel {
    private int IDRoupa;
    private String tipo;
    private String tamanho;

    public RoupaModel(int IDRoupa, String tipo, String tamanho){
        this.IDRoupa = IDRoupa;
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    public int getIDRoupa() {
        return IDRoupa;
    }

    public void setIDRoupa(int ID) {
        this.IDRoupa = ID;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tm) {
        this.tamanho = tm;
    }
}
