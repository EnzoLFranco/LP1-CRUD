package com.example.lp1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class AviaoController extends HelloController{
    private int numeroSerie;
    private String fabricante;
    private String modelo;

    @FXML
    private Label info;
    @FXML
    private TextField modeloInput;

    public int getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void abastecer(ActionEvent event) {
        modelo = modeloInput.getText();
        info.setText(modelo + " está sendo abastecido.");
    }
    public void decolar(ActionEvent event) {
        modelo = modeloInput.getText();
        info.setText(modelo + " está começando a decolagem.");
    }
    public void pousar(ActionEvent event) {
        modelo = modeloInput.getText();
        info.setText(modelo + " está pousando.");
    }
}
