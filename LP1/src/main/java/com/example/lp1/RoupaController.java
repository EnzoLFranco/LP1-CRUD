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
import com.example.lp1.models.RoupaModel;

public class RoupaController extends HelloController {
    private int IDRoupa;
    private String tipo;
    private String tamanho;

    @FXML
    private Label info;
    @FXML
    private TextField tipoInput;
    @FXML
    private TextField corInput;
    @FXML
    private TableView<RoupaModel> tableView;
    @FXML
    private TableColumn<RoupaModel, String> idColumn;
    @FXML
    private TableColumn<RoupaModel, String> tipoColumn;
    @FXML
    private TableColumn<RoupaModel, String> tamanhoColumn;

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

    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("IDRoupa"));
        tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tamanhoColumn.setCellValueFactory(new PropertyValueFactory<>("tamanho"));

        carregarTabela();
    }

    private void carregarTabela() {
        List<RoupaModel> roupas = getRoupasDoBanco();

        tableView.getItems().clear();
        tableView.getItems().addAll(roupas);
    }

    private List<RoupaModel> getRoupasDoBanco() {
        List<RoupaModel> roupas = new ArrayList<>();
        String sql = "SELECT * FROM Roupa";

        try (Connection conn = DatabaseConnection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {

            while (rs.next()) {
                int idRoupa = rs.getInt("IDRoupa");
                String tipo = rs.getString("tipo");
                String tamanho = rs.getString("tamanho");

                RoupaModel roupa = new RoupaModel(idRoupa, tipo, tamanho);
                roupas.add(roupa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roupas;
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
