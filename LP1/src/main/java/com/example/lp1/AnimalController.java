package com.example.lp1;

import com.example.lp1.helpers.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
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
    private TableView<AnimalModel> tableView;

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
        TableColumn<AnimalModel, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("IDAnimal"));

        TableColumn<AnimalModel, String> nomeColumn = new TableColumn<>("Nome");
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<AnimalModel, String> especieColumn = new TableColumn<>("Espécie");
        especieColumn.setCellValueFactory(new PropertyValueFactory<>("especie"));

        tableView.getColumns().addAll(idColumn, nomeColumn, especieColumn);

        carregarTabela();
    }

    private void carregarTabela() {
        List<AnimalModel> animais = getAnimaisDoBanco();

        tableView.getItems().clear();
        tableView.getItems().addAll(animais);
    }

    private List<AnimalModel> getAnimaisDoBanco() {
        List<AnimalModel> animais = new ArrayList<>();
        String sql = "SELECT * FROM animais";

        try (Connection conn = DatabaseConnection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("IDAnimal");
                String nome = rs.getString("nome");
                String especie = rs.getString("especie");

                AnimalModel animal = new AnimalModel(id, nome, especie);

                animais.add(animal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return animais;
    }
}
