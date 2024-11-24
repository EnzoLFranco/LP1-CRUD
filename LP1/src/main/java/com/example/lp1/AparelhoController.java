package com.example.lp1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class AparelhoController extends HelloController{
    private int numeroSerie;
    private String marca;
    private String tipo;

    @FXML
    private Label info;
    @FXML
    private TextField marcaInput;
    @FXML
    private TextField tipoInput;

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

    public void ligar(ActionEvent event) {
        tipo = tipoInput.getText();
        marca = marcaInput.getText();
        info.setText("O " + tipo + " da marca " + marca +" está ligado.");
    }
    public void desligar(ActionEvent event) {
        tipo = tipoInput.getText();
        marca = marcaInput.getText();
        info.setText("O " + tipo + " da marca " + marca +" está desligado.");
    }
    public void redefinirConfigurações() {
        tipo = tipoInput.getText();
        marca = marcaInput.getText();
        info.setText("Configurações do " + tipo + " " + marca + " redefinidas.");
    }
}
