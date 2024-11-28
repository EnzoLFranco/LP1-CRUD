package com.example.lp1.models;

public class PokemonModel {
    private int numeroPokedex;
    private String nome;
    private String tipos;

    public PokemonModel(int numeroPokedex, String nome, String tipos){
        this.numeroPokedex = numeroPokedex;
        this.nome = nome;
        this.tipos = tipos;
    }

    public int getNumeroPokedex() {
        return numeroPokedex;
    }

    public void setNumeroPokedex(int numeroPokedex) {
        this.numeroPokedex = numeroPokedex;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipos() {
        return tipos;
    }

    public void setTipos(String tipos) {
        this.tipos = tipos;
    }
}
