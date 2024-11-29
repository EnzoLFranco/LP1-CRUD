package com.example.lp1;

import com.example.lp1.helpers.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.lp1.models.PowerRangerModel;

public class PowerRangerController extends HelloController {
    private String nome;
    private String corUniforme;
    private String zord;

    @FXML
    private Label info;
    @FXML
    private TextField nomeInput;
    @FXML
    private TextField corInput;
    @FXML
    private TextField zordInput;
    @FXML
    private TableView<PowerRangerModel> tableView;
    @FXML
    private TableColumn<PowerRangerModel, String> nomeColumn;
    @FXML
    private TableColumn<PowerRangerModel, String> corColumn;
    @FXML
    private TableColumn<PowerRangerModel, String> zordColumn;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCorUniforme() {
        return corUniforme;
    }
    public void setCorUniforme(String corUniforme) {
        this.corUniforme = corUniforme;
    }
    public String getZord() {
        return zord;
    }
    public void setZord(String zord) {
        this.zord = zord;
    }

    public void initialize() {
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        corColumn.setCellValueFactory(new PropertyValueFactory<>("corUniforme"));
        zordColumn.setCellValueFactory(new PropertyValueFactory<>("zord"));

        carregarTabela();
    }

    private void carregarTabela() {
        List<PowerRangerModel> powerRangers = getPowerRangersDoBanco();

        tableView.getItems().clear();
        tableView.getItems().addAll(powerRangers);
    }

    private List<PowerRangerModel> getPowerRangersDoBanco() {
        List<PowerRangerModel> powerRangers = new ArrayList<>();
        String sql = "SELECT * FROM PowerRanger";

        try (Connection conn = DatabaseConnection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {

            while (rs.next()) {
                String nome = rs.getString("nome");
                String corUniforme = rs.getString("corUniforme");
                String zord = rs.getString("zord");
                PowerRangerModel powerRanger = new PowerRangerModel(nome, corUniforme, zord);
                powerRangers.add(powerRanger);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return powerRangers;
    }

    public void morfar(ActionEvent event) {
        nome = nomeInput.getText();
        corUniforme = corInput.getText();
        info.setText(nome + " equipou o uniforme " + corUniforme + "!");
    }
    public void atacar(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText(nome + " está atacando!");
    }
    public void chamarZord(ActionEvent event) {
        nome = nomeInput.getText();
        zord = zordInput.getText();
        info.setText(nome + " chamou o Zord " + zord + "!");
    }
}
