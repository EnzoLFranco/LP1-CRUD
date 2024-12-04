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
import com.example.lp1.models.CarroModel;

public class CarroController extends HelloController {
    private String placa;
    private String marca;
    private String modelo;

    @FXML
    private Label info;
    @FXML
    private TextField modeloInput;
    @FXML
    private TextField marcaInput;
    @FXML
    private TableView<CarroModel> tableView;
    @FXML
    private TableColumn<CarroModel, String> placaColumn;
    @FXML
    private TableColumn<CarroModel, String> marcaColumn;
    @FXML
    private TableColumn<CarroModel, String> modeloColumn;

    private CarroModel selectedCarro;

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String pl) {
        this.placa = pl;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String mc) {
        this.marca = mc;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String md) {
        this.modelo = md;
    }

    public void initialize() {
        placaColumn.setCellValueFactory(new PropertyValueFactory<>("placa"));
        marcaColumn.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modeloColumn.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        carregarTabela();

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedCarro = newValue;
                marcaInput.setText(newValue.getMarca());
                modeloInput.setText(newValue.getModelo());
            }
        });
    }

    private void carregarTabela() {
        List<CarroModel> carros = getCarrosDoBanco();

        tableView.getItems().clear();
        tableView.getItems().addAll(carros);
    }

    private List<CarroModel> getCarrosDoBanco() {
        List<CarroModel> carros = new ArrayList<>();
        String sql = "SELECT * FROM Carro";

        try (Connection conn = DatabaseConnection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {

            while (rs.next()) {
                String placa = rs.getString("placa");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                CarroModel carro = new CarroModel(placa, marca, modelo);
                carros.add(carro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carros;
    }

    public void atualizarCarro(ActionEvent event) {
        if (selectedCarro == null) {
            info.setText("Selecione um carro para atualizar.");
            return;
        }

        String novaMarca = marcaInput.getText();
        String novoModelo = modeloInput.getText();

        if (novaMarca.isEmpty() || novoModelo.isEmpty()) {
            info.setText("Marca e modelo não podem ser vazios.");
            return;
        }

        String sql = "UPDATE Carro SET marca = ?, modelo = ? WHERE placa = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novaMarca);
            stmt.setString(2, novoModelo);
            stmt.setString(3, selectedCarro.getPlaca());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                selectedCarro.setMarca(novaMarca);
                selectedCarro.setModelo(novoModelo);
                tableView.refresh();
                info.setText("Carro atualizado com sucesso!");
            } else {
                info.setText("Erro ao atualizar o carro.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            info.setText("Erro ao atualizar o carro.");
        }
    }

    public void deletarCarro(ActionEvent event) {
        if (selectedCarro == null) {
            info.setText("Selecione um carro para deletar.");
            return;
        }

        String sql = "DELETE FROM Carro WHERE placa = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, selectedCarro.getPlaca());

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                tableView.getItems().remove(selectedCarro);
                info.setText("Carro deletado com sucesso!");
            } else {
                info.setText("Erro ao deletar o carro.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            info.setText("Erro ao deletar o carro.");
        }
    }

    public void ligar(ActionEvent event) {
        marca = marcaInput.getText();
        modelo = modeloInput.getText();
        info.setText("Você ligou seu " + marca + " " + modelo + "!");
    }
    public void acelerar(ActionEvent event) {
        marca = marcaInput.getText();
        modelo = modeloInput.getText();
        info.setText("Você acelerou seu " + marca + " " + modelo + "!");
    }
    public void frear(ActionEvent event) {
        marca = marcaInput.getText();
        modelo = modeloInput.getText();
        info.setText("Você freou seu " + marca + " " + modelo + "!");
    }
}
