package com.example.lp1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RoupaController extends HelloController{
    private int IDRoupa;
    private String tipo;
    private String tamanho;

    @FXML
    private Label info;
    @FXML
    private TextField tipoInput;
    @FXML
    private TextField corInput;

    public int getIDRoupa() {
        return IDRoupa;
    }
    public void setIDRoupa(int ID) {
        this.IDRoupa = ID;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tm) {
        this.tamanho = tm;
    }

    public void vestir(ActionEvent event) {
        tipo = tipoInput.getText();
        String cor = corInput.getText();
        info.setText("Você vestiu um(a) " + tipo + " " + cor);
    }
    public void dobrar(ActionEvent event) {
        tipo = tipoInput.getText();
        info.setText("Você dobrou um(a) " + tipo);
    }
    public void lavar(ActionEvent event) {
        tipo = tipoInput.getText();
        info.setText("Você lavou um(a) " + tipo);
    }
}
