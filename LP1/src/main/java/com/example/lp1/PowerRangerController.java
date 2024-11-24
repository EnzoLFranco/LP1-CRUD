package com.example.lp1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class PowerRangerController extends HelloController{
    private String nome;
    private String corUniforme;
    private String zord;

    @FXML
    private Label info;
    @FXML
    private TextField nomeInput;
    @FXML
    private TextField corInput;
    @FXML
    private TextField zordInput;

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

    public void morfar(ActionEvent event) {
        nome = nomeInput.getText();
        corUniforme = corInput.getText();
        info.setText(nome + " equipou o uniforme " + corUniforme + "!");
    }
    public void atacar(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText(nome + " está atacando!");
    }
    public void chamarZord(ActionEvent event) {
        nome = nomeInput.getText();
        zord = zordInput.getText();
        info.setText(nome + " chamou o Zord " + zord + "!");
    }
}
