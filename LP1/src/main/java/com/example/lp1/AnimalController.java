package com.example.lp1;

import com.example.lp1.helpers.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.lp1.models.AnimalModel;

public class AnimalController extends HelloController {
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

    private AnimalModel selectedAnimal;

    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("IDAnimal"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        especieColumn.setCellValueFactory(new PropertyValueFactory<>("especie"));

        tableView.setEditable(true);
        nomeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        especieColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedAnimal = newSelection;
                nomeInput.setText(selectedAnimal.getNome());
                racaoInput.setText("");
                distaciaInput.setText("");
            }
        });

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
                AnimalModel animal = new AnimalModel(id, nome, especie);
                animais.add(animal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return animais;
    }

    public void salvarAlteracoes(ActionEvent event) {
        if (selectedAnimal == null) {
            info.setText("Selecione um animal para atualizar.");
            return;
        }

        String novoNome = nomeInput.getText();
        String novaEspecie = selectedAnimal.getEspecie();

        String sql = "UPDATE Animal SET nome = ?, especie = ? WHERE IDAnimal = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoNome);
            stmt.setString(2, novaEspecie);
            stmt.setInt(3, selectedAnimal.getIDAnimal());
            stmt.executeUpdate();

            selectedAnimal.setNome(novoNome);
            atualizarTabela();

            info.setText("Animal atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            info.setText("Erro ao atualizar animal.");
        }
    }

    @FXML
    private void excluirAnimal(ActionEvent event) {
        AnimalModel selectedAnimal = tableView.getSelectionModel().getSelectedItem();
        if (selectedAnimal == null) {
            info.setText("Selecione um animal para excluir.");
            return;
        }

        String sql = "DELETE FROM Animal WHERE IDAnimal = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, selectedAnimal.getIDAnimal());
            stmt.executeUpdate();

            tableView.getItems().remove(selectedAnimal);

            info.setText("Animal excluído com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            info.setText("Erro ao excluir animal.");
        }
    }


    private void atualizarTabela() {
        tableView.refresh();
    }

    public void andar(ActionEvent event) {
        String nome = nomeInput.getText();
        int distancia = Integer.parseInt(distaciaInput.getText());
        info.setText(nome + " andou " + distancia + " metros.");
    }

    public void comer(ActionEvent event) {
        String nome = nomeInput.getText();
        String comida = racaoInput.getText();
        info.setText(nome + " comeu " + comida + "!");
    }

    public void dormir(ActionEvent event) {
        String nome = nomeInput.getText();
        info.setText(nome + " está dormindo!");
    }
}
