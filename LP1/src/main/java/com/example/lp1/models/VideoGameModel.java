package com.example.lp1.models;

import com.mysql.cj.util.DnsSrv;

public class VideoGameModel {
    private String nome;
    private String genero;
    private int classificacaoEtaria;

    public VideoGameModel(String nome, String genero, int classificacaoEtaria){
        this.nome = nome;
        this.genero = genero;
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getClassificacaoEtaria() {
        return classificacaoEtaria;
    }

    public void setClassificacaoEtaria(int classificacaoEtaria) {
        this.classificacaoEtaria = classificacaoEtaria;
    }
}
