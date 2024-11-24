package com.example.lp1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class InstrumentoController extends HelloController{
    private int IDInstrumento;
    private String nome;
    private int numeroCordas;

    @FXML
    private Label info;
    @FXML
    private TextField nomeInput;
    @FXML
    private TextField musicaInput;
    @FXML
    private TextField cordasInput;

    public int getIDInstrumento() {
        return IDInstrumento;
    }
    public void setIDInstrumento(int IDIns) {
        this.IDInstrumento = IDIns;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNumeroCordas() {
        return numeroCordas;
    }
    public void setNumeroCordas(int numCordas) {
        this.numeroCordas = numCordas;
    }

public void tocar(ActionEvent event) {
    nome = nomeInput.getText();
    String musica = musicaInput.getText();
    info.setText("Você tocou a música " + musica + " no " + nome);
}
public void afinar(ActionEvent event) {
    nome = nomeInput.getText();
    info.setText("Você afinou seu " + nome + "!");
}
public void trocarCordas(ActionEvent event) {
    String nome = nomeInput.getText();
    int numTrocado = Integer.parseInt(cordasInput.getText());
    info.setText("Você trocou " + numTrocado + " cordas do seu " + nome + "!");
}
}
