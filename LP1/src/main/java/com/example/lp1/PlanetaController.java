package com.example.lp1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class PlanetaController extends HelloController{
    private String nome;
    private float raio;
    private String massa;

    @FXML
    private Label info;
    @FXML
    private TextField nomeInput;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getRaio() {
        return raio;
    }
    public void setRaio(float raio) {
        this.raio = raio;
    }
    public String getMassa() {
        return massa;
    }
    public void setMassa(String massa) {
        this.massa = massa;
    }

    public void orbitar(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText("O planeta " + nome + " está orbitando o Sol.");
    }
    public void rotacionar(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText("O planeta " + nome + " está rotacionando.");
    }
    public void mostrarComposição(ActionEvent event) {
        nome = nomeInput.getText();
        if(nome.equals("Mercúrio") || nome.equals("Vênus") || nome.equals("Terra") || nome.equals("Marte")){
            info.setText("O planeta é terrestre.");
        } else {
            info.setText("O planeta é gasoso.");
        }
    }
}
