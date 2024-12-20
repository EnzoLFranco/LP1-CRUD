package com.example.lp1.models;

public class AparelhoModel {
    private int numeroSerie;
    private String marca;
    private String tipo;

    public AparelhoModel(int numeroSerie, String marca, String tipo){
        this.numeroSerie = numeroSerie;
        this.tipo = tipo;
        this.marca = marca;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
