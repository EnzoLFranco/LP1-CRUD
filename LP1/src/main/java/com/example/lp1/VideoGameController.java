package com.example.lp1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VideoGameController extends HelloController {
    private String nome;
    private String genero;
    private int classificacaoEtaria;

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

    public void iniciar(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText("Iniciando " + nome + "...");
    }
    public void salvarProgresso(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText("Salvando seu progresso em " + nome + "!");
    }
    public void carregarProgresso(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText("Carregando seu progresso em " + nome + "!");
    }
}
