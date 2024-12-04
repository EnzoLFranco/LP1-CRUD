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
import com.example.lp1.models.AviaoModel;

public class AviaoController extends HelloController {
    private int numeroSerie;
    private String fabricante;
    private String modelo;

    @FXML
    private Label info;
    @FXML
    private TextField modeloInput;
    @FXML
    private TextField fabricanteInput;
    @FXML
    private TableView<AviaoModel> tableView;
    @FXML
    private TableColumn<AviaoModel, Integer> numSerieColumn;
    @FXML
    private TableColumn<AviaoModel, String> fabricanteColumn;
    @FXML
    private TableColumn<AviaoModel, String> modeloColumn;

    private AviaoModel selectedAviao;

    public int getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void initialize() {
        numSerieColumn.setCellValueFactory(new PropertyValueFactory<>("numeroSerie"));
        fabricanteColumn.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
        modeloColumn.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        carregarTabela();

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedAviao = newValue;
                fabricanteInput.setText(newValue.getFabricante());
                modeloInput.setText(newValue.getModelo());
            }
        });
    }

    private void carregarTabela() {
        List<AviaoModel> avioes = getAvioesDoBanco();
        tableView.getItems().clear();
        tableView.getItems().addAll(avioes);
    }

    private List<AviaoModel> getAvioesDoBanco() {
        List<AviaoModel> avioes = new ArrayList<>();
        String sql = "SELECT * FROM Aviao";

        try (Connection conn = DatabaseConnection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {

            while (rs.next()) {
                int numeroSerie = rs.getInt("numeroSerie");
                String fabricante = rs.getString("fabricante");
                String modelo = rs.getString("modelo");
                AviaoModel aviao = new AviaoModel(numeroSerie, fabricante, modelo);
                avioes.add(aviao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return avioes;
    }

    @FXML
    private void atualizarAviao(ActionEvent event) {
        AviaoModel selectedAviao = tableView.getSelectionModel().getSelectedItem();
        if (selectedAviao == null) {
            info.setText("Selecione um avião para atualizar.");
            return;
        }
        String modelo = modeloInput.getText();
        String fabricante = fabricanteInput.getText();

        String sql = "UPDATE Aviao SET fabricante = ?, modelo = ? WHERE numeroSerie = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fabricante);
            stmt.setString(2, modelo);
            stmt.setInt(3, selectedAviao.getNumeroSerie());
            stmt.executeUpdate();

            selectedAviao.setModelo(modelo);
            selectedAviao.setFabricante(fabricante);
            tableView.refresh();

            info.setText("Avião atualizado com sucesso!");
            carregarTabela();
        } catch (SQLException e) {
            e.printStackTrace();
            info.setText("Erro ao atualizar avião.");
        }
    }

    @FXML
    private void excluirAviao(ActionEvent event) {
        AviaoModel selectedAviao = tableView.getSelectionModel().getSelectedItem();
        if (selectedAviao == null) {
            info.setText("Selecione um avião para excluir.");
            return;
        }

        String sql = "DELETE FROM Aviao WHERE numeroSerie = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, selectedAviao.getNumeroSerie());
            stmt.executeUpdate();

            tableView.getItems().remove(selectedAviao);

            info.setText("Avião excluído com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            info.setText("Erro ao excluir avião.");
        }
    }



    public void abastecer(ActionEvent event) {
        modelo = modeloInput.getText();
        info.setText(modelo + " está sendo abastecido.");
    }

    public void decolar(ActionEvent event) {
        modelo = modeloInput.getText();
        info.setText(modelo + " está começando a decolagem.");
    }

    public void pousar(ActionEvent event) {
        modelo = modeloInput.getText();
        info.setText(modelo + " está pousando.");
    }
}
