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
import com.example.lp1.models.PlanetaModel;

public class PlanetaController extends HelloController {
    private String nome;
    private float raio;
    private String massa;

    @FXML
    private Label info;
    @FXML
    private TextField nomeInput;
    @FXML
    private TableView<PlanetaModel> tableView;
    @FXML
    private TableColumn<PlanetaModel, String> nomeColumn;
    @FXML
    private TableColumn<PlanetaModel, Float> raioColumn;
    @FXML
    private TableColumn<PlanetaModel, Integer> massaColumn;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getRaio() {
        return raio;
    }
    public void setRaio(float raio) {
        this.raio = raio;
    }
    public String getMassa() {
        return massa;
    }
    public void setMassa(String massa) {
        this.massa = massa;
    }

    public void initialize() {
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        raioColumn.setCellValueFactory(new PropertyValueFactory<>("raio"));
        massaColumn.setCellValueFactory(new PropertyValueFactory<>("massa"));

        carregarTabela();
    }

    private void carregarTabela() {
        List<PlanetaModel> planetas = getPlanetasDoBanco();

        tableView.getItems().clear();
        tableView.getItems().addAll(planetas);
    }

    private List<PlanetaModel> getPlanetasDoBanco() {
        List<PlanetaModel> planetas = new ArrayList<>();
        String sql = "SELECT * FROM Planeta";

        try (Connection conn = DatabaseConnection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {

            while (rs.next()) {
                String nome = rs.getString("nome");
                Float raio = rs.getFloat("raio");
                String massa = rs.getString("massa");
                PlanetaModel planeta = new PlanetaModel(nome, raio, massa);
                planetas.add(planeta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return planetas;
    }

    public void orbitar(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText("O planeta " + nome + " está orbitando o Sol.");
    }
    public void rotacionar(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText("O planeta " + nome + " está rotacionando.");
    }
    public void mostrarComposição(ActionEvent event) {
        nome = nomeInput.getText();
        if(nome.equals("Mercúrio") || nome.equals("Vênus") || nome.equals("Terra") || nome.equals("Marte")){
            info.setText("O planeta é terrestre.");
        } else {
            info.setText("O planeta é gasoso.");
        }
    }
}
