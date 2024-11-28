package com.example.lp1;

import com.example.lp1.helpers.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.lp1.models.AnimalModel;

public class AnimalController extends HelloController {
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
    @FXML
    private TableView<AnimalModel> tableView;
    @FXML
    private TableColumn<AnimalModel, Integer> idColumn;
    @FXML
    private TableColumn<AnimalModel, String> nomeColumn;
    @FXML
    private TableColumn<AnimalModel, String> especieColumn;

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

    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("IDAnimal"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        especieColumn.setCellValueFactory(new PropertyValueFactory<>("especie"));

        carregarTabela();
    }


    private void carregarTabela() {
        List<AnimalModel> animais = getAnimaisDoBanco();

        tableView.getItems().clear();
        tableView.getItems().addAll(animais);
    }

    private List<AnimalModel> getAnimaisDoBanco() {
        List<AnimalModel> animais = new ArrayList<>();
        String sql = "SELECT * FROM Animal";

        try (Connection conn = DatabaseConnection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("IDAnimal");
                String nome = rs.getString("nome");
                String especie = rs.getString("especie");

                System.out.println("Animal encontrado: ID = " + id + ", Nome = " + nome + ", Espécie = " + especie);

                AnimalModel animal = new AnimalModel(id, nome, especie);
                animais.add(animal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return animais;
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
