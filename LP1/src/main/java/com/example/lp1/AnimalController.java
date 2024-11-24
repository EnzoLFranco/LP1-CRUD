package com.example.lp1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class AnimalController extends HelloController{
    private int IDAnimal;
    private String nome;
    private String especie;

    @FXML
    private Label info;
    @FXML
    private TextField nomeInput;
    @FXML
    private TextField racaoInput;
    @FXML
    private TextField distaciaInput;

    public int getIDAnimal() {
        return IDAnimal;
    }
    public void setIDAnimal(int ID) {
        this.IDAnimal = ID;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String espc) {
        this.especie = espc;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nm) {
        this.nome = nm;
    }

    public void andar(ActionEvent event){
        nome = nomeInput.getText();
        int distancia = Integer.parseInt(distaciaInput.getText());
        info.setText(nome + " andou " + distancia + " metros.");
    }
    public void comer(ActionEvent event){
        nome = nomeInput.getText();
        String comida = racaoInput.getText();
        info.setText(nome + " comeu " + comida + "!");
    }
    public void dormir(ActionEvent event){
        nome = nomeInput.getText();
        info.setText(nome + " está dormindo!");
    }

}
