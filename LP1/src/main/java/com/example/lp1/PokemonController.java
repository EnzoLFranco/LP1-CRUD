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
import com.example.lp1.models.PokemonModel;

public class PokemonController extends HelloController {
    private int numeroPokedex;
    private String nome;
    private String tipos;

    @FXML
    private Label info;
    @FXML
    private TextField nomeInput;
    @FXML
    private TableView<PokemonModel> tableView;
    @FXML
    private TableColumn<PokemonModel, Integer> numeroPokedexColumn;
    @FXML
    private TableColumn<PokemonModel, String> nomeColumn;
    @FXML
    private TableColumn<PokemonModel, String> tiposColumn;


    public int getNumeroPokedex() {
        return numeroPokedex;
    }
    public void setNumeroPokedex(int numeroPokedex) {
        this.numeroPokedex = numeroPokedex;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTipos() {
        return tipos;
    }
    public void setTipos(String tipos) {
        this.tipos = tipos;
    }

    public void initialize() {
        numeroPokedexColumn.setCellValueFactory(new PropertyValueFactory<>("numeroPokedex"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tiposColumn.setCellValueFactory(new PropertyValueFactory<>("tipos"));

        carregarTabela();
    }

    private void carregarTabela() {
        List<PokemonModel> pokemons = getPokemonsDoBanco();

        tableView.getItems().clear();
        tableView.getItems().addAll(pokemons);
    }

    private List<PokemonModel> getPokemonsDoBanco() {
        List<PokemonModel> pokemons = new ArrayList<>();
        String sql = "SELECT * FROM Pokemon";

        try (Connection conn = DatabaseConnection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {

            while (rs.next()) {
                int numeroPokedex = rs.getInt("numeroPokedex");
                String nome = rs.getString("nome");
                String tipos = rs.getString("tipos");
                PokemonModel pokemon = new PokemonModel(numeroPokedex, nome, tipos);
                pokemons.add(pokemon);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pokemons;
    }

    public void dormir(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText(nome + " está dormindo.");
    }
    public void atacar(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText(nome + " está atacando!");
    }
    public void comer(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText(nome + " está comendo para recuperar energia.");
    }

}
