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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.lp1.models.AparelhoModel;

public class AparelhoController extends HelloController {
    private int numeroSerie;
    private String marca;
    private String tipo;

    @FXML
    private Label info;
    @FXML
    private TextField marcaInput;
    @FXML
    private TextField tipoInput;
    @FXML
    private TableView<AparelhoModel> tableView;
    @FXML
    private TableColumn<AparelhoModel, Integer> numSerieColumn;
    @FXML
    private TableColumn<AparelhoModel, String> marcaColumn;
    @FXML
    private TableColumn<AparelhoModel, String> tipoColumn;

    private AparelhoModel selectedAparelho;

    public int getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void initialize() {
        numSerieColumn.setCellValueFactory(new PropertyValueFactory<>("numeroSerie"));
        marcaColumn.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        carregarTabela();

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedAparelho = newValue;
                marcaInput.setText(newValue.getMarca());
                tipoInput.setText(newValue.getTipo());
            }
        });
    }

    private void carregarTabela() {
        List<AparelhoModel> aparelhos = getAparelhosDoBanco();

        tableView.getItems().clear();
        tableView.getItems().addAll(aparelhos);
    }

    private List<AparelhoModel> getAparelhosDoBanco() {
        List<AparelhoModel> aparelhos = new ArrayList<>();
        String sql = "SELECT * FROM Aparelho";

        try (Connection conn = DatabaseConnection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {

            while (rs.next()) {
                int numeroSerie = rs.getInt("numeroSerie");
                String marca = rs.getString("marca");
                String tipo = rs.getString("tipo");
                AparelhoModel aparelho = new AparelhoModel(numeroSerie, marca, tipo);
                aparelhos.add(aparelho);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aparelhos;
    }

    @FXML
    private void atualizarAparelho(ActionEvent event) {
        if (selectedAparelho == null) {
            info.setText("Selecione um aparelho para atualizar.");
            return;
        }

        String marca = marcaInput.getText();
        String tipo = tipoInput.getText();

        if (marca.isEmpty() || tipo.isEmpty()) {
            info.setText("Marca e tipo não podem estar vazios.");
            return;
        }

        String sql = "UPDATE Aparelho SET marca = ?, tipo = ? WHERE numeroSerie = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, marca);
            stmt.setString(2, tipo);
            stmt.setInt(3, selectedAparelho.getNumeroSerie());
            stmt.executeUpdate();

            selectedAparelho.setMarca(marca);
            selectedAparelho.setTipo(tipo);
            tableView.refresh();

            info.setText("Aparelho atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            info.setText("Erro ao atualizar aparelho.");
        }
    }

    @FXML
    private void excluirAparelho(ActionEvent event) {
        if (selectedAparelho == null) {
            info.setText("Selecione um aparelho para excluir.");
            return;
        }

        String sql = "DELETE FROM Aparelho WHERE numeroSerie = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, selectedAparelho.getNumeroSerie());
            stmt.executeUpdate();

            tableView.getItems().remove(selectedAparelho);

            info.setText("Aparelho excluído com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            info.setText("Erro ao excluir aparelho.");
        }
    }

    public void ligar(ActionEvent event) {
        tipo = tipoInput.getText();
        marca = marcaInput.getText();
        info.setText("O " + tipo + " da marca " + marca +" está ligado.");
    }

    public void desligar(ActionEvent event) {
        tipo = tipoInput.getText();
        marca = marcaInput.getText();
        info.setText("O " + tipo + " da marca " + marca +" está desligado.");
    }

    public void redefinirConfigurações() {
        tipo = tipoInput.getText();
        marca = marcaInput.getText();
        info.setText("Configurações do " + tipo + " " + marca + " redefinidas.");
    }
}
