package com.example.lp1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class CarroController extends HelloController{
    private String placa;
    private String marca;
    private String modelo;

    @FXML
    private Label info;
    @FXML
    private TextField modeloInput;
    @FXML
    private TextField marcaInput;

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String pl) {
        this.placa = pl;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String mc) {
        this.marca = mc;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String md) {
        this.modelo = md;
    }

    public void ligar(ActionEvent event) {
        marca = marcaInput.getText();
        modelo = modeloInput.getText();
        info.setText("Você ligou seu " + marca + " " + modelo + "!");
    }
    public void acelerar(ActionEvent event) {
        marca = marcaInput.getText();
        modelo = modeloInput.getText();
        info.setText("Você acelerou seu " + marca + " " + modelo + "!");
    }
    public void frear(ActionEvent event) {
        marca = marcaInput.getText();
        modelo = modeloInput.getText();
        info.setText("Você freou seu " + marca + " " + modelo + "!");
    }
}
