package com.example.lp1.models;

public class AnimalModel {
    private int IDAnimal;
    private String nome;
    private String especie;

    public AnimalModel(int IDAnimal, String nome, String especie) {
        this.IDAnimal = IDAnimal;
        this.nome = nome;
        this.especie = especie;
    }

    public int getIDAnimal() {
        return IDAnimal;
    }

    public void setIDAnimal(int IDAnimal) {
        this.IDAnimal = IDAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
