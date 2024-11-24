package com.example.lp1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class PokemonController extends HelloController{
    private int numeroPokedex;
    private String nome;
    private String tipos;

    @FXML
    private Label info;
    @FXML
    private TextField nomeInput;


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

    public void dormir(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText(nome + " está dormindo.");
    }
    public void atacar(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText(nome + " está atacando!");
    }
    public void comer(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText(nome + " está comendo para recuperar energia.");
    }

}
