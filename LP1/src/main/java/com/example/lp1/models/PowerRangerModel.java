package com.example.lp1.models;

public class PowerRangerModel {
    private String nome;
    private String corUniforme;
    private String zord;

    public PowerRangerModel(String nome, String corUniforme, String zord){
        this.nome = nome;
        this.corUniforme = corUniforme;
        this.zord = zord;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCorUniforme() {
        return corUniforme;
    }

    public void setCorUniforme(String corUniforme) {
        this.corUniforme = corUniforme;
    }

    public String getZord() {
        return zord;
    }

    public void setZord(String zord) {
        this.zord = zord;
    }
}
