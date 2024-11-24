package com.example.lp1.models;

public class InstrumentoModel {
    private int IDInstrumento;
    private String nome;
    private int numeroCordas;

    public int getIDInstrumento() {
        return IDInstrumento;
    }

    public void setIDInstrumento(int IDIns) {
        this.IDInstrumento = IDIns;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroCordas() {
        return numeroCordas;
    }

    public void setNumeroCordas(int numCordas) {
        this.numeroCordas = numCordas;
    }
}
