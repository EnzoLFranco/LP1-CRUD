package com.example.lp1;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import com.example.lp1.helpers.DatabaseConnection;

import java.sql.SQLException;

public class CadastroController extends HelloController {

    @FXML
    private ComboBox<String> objectSelector;

    @FXML
    private VBox fieldsContainer;

    @FXML
    private Button saveButton;

    @FXML
    public void initialize() {
        objectSelector.setItems(FXCollections.observableArrayList(
                "Animal", "Aparelho", "Avião", "Carro", "Instrumento", "Planeta", "Pokemon", "Power Ranger", "Roupa", "VideoGame"
        ));

        // Configura a ação ao alterar o objeto selecionado
        objectSelector.setOnAction(event -> updateFields(objectSelector.getValue()));
    }

    private void updateFields(String selectedObject) {
        fieldsContainer.getChildren().clear();

        switch (selectedObject) {
            case "Animal":
                fieldsContainer.getChildren().addAll(
                        createTextField("ID Animal"),
                        createTextField("Nome"),
                        createTextField("Espécie")
                );
                break;

            case "Aparelho":
                fieldsContainer.getChildren().addAll(
                        createTextField("Número de Série"),
                        createTextField("Marca"),
                        createTextField("Tipo")
                );
                break;

            case "Avião":
                fieldsContainer.getChildren().addAll(
                        createTextField("Número de Série"),
                        createTextField("Fabricante"),
                        createTextField("Modelo")
                );
                break;

            case "Carro":
                fieldsContainer.getChildren().addAll(
                        createTextField("Placa"),
                        createTextField("Marca"),
                        createTextField("Modelo")
                );
                break;

            case "Instrumento":
                fieldsContainer.getChildren().addAll(
                        createTextField("ID Instrumento"),
                        createTextField("Nome"),
                        createTextField("Número de Cordas")
                );
                break;

            case "Planeta":
                fieldsContainer.getChildren().addAll(
                        createTextField("Nome"),
                        createTextField("Raio"),
                        createTextField("Massa")
                );
                break;

            case "Pokemon":
                fieldsContainer.getChildren().addAll(
                        createTextField("Número Pokedex"),
                        createTextField("Nome"),
                        createTextField("Tipos")
                );
                break;

            case "Power Ranger":
                fieldsContainer.getChildren().addAll(
                        createTextField("Nome"),
                        createTextField("Cor do Uniforme"),
                        createTextField("Zord")
                );
                break;

            case "Roupa":
                fieldsContainer.getChildren().addAll(
                        createTextField("ID Roupa"),
                        createTextField("Tipo"),
                        createTextField("Tamanho"),
                        createTextField("Cor")
                );
                break;

            case "VideoGame":
                fieldsContainer.getChildren().addAll(
                        createTextField("Nome"),
                        createTextField("Gênero"),
                        createTextField("Classificação Etária")
                );
                break;
        }
    }

    private TextField createTextField(String promptText) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        return textField;
    }

    @FXML
    private void handleSave() {
        String selectedObject = objectSelector.getValue();
        if (selectedObject == null || selectedObject.isEmpty()) {
            showAlert("Erro", "Por favor, selecione um objeto para cadastrar.");
            return;
        }

        try {
            switch (selectedObject) {
                case "Animal" -> saveAnimal();
                case "Aparelho" -> saveAparelho();
                case "Avião" -> saveAviao();
                case "Carro" -> saveCarro();
                case "Instrumento" -> saveInstrumento();
                case "Planeta" -> savePlaneta();
                case "Pokemon" -> savePokemon();
                case "Power Ranger" -> savePowerRanger();
                case "Roupa" -> saveRoupa();
                case "VideoGame" -> saveVideoGame();
                default -> showAlert("Erro", "Objeto desconhecido.");
            }
        } catch (SQLException e) {
            showAlert("Erro", "Erro ao salvar no banco de dados: " + e.getMessage());
        }
    }

    private void saveAnimal() throws SQLException {
        String nome = getFieldValue(0);
        String especie = getFieldValue(1);

        String sql = "INSERT INTO Animal (nome, especie) VALUES (?, ?)";
        int result = DatabaseConnection.executeUpdate(sql, nome, especie);

        showSaveResult(result);
    }

    private void saveAparelho() throws SQLException {
        String marca = getFieldValue(0);
        String tipo = getFieldValue(1);

        String sql = "INSERT INTO Aparelho (marca, tipo) VALUES (?, ?)";
        int result = DatabaseConnection.executeUpdate(sql, marca, tipo);

        showSaveResult(result);
    }

    private void saveAviao() throws SQLException {
        String fabricante = getFieldValue(0);
        String modelo = getFieldValue(1);

        String sql = "INSERT INTO Aviao (fabricante, modelo) VALUES (?, ?)";
        int result = DatabaseConnection.executeUpdate(sql, fabricante, modelo);

        showSaveResult(result);
    }

    private void saveCarro() throws SQLException {
        String fabricante = getFieldValue(0);
        String modelo = getFieldValue(1);

        String sql = "INSERT INTO Aviao (fabricante, modelo) VALUES (?, ?)";
        int result = DatabaseConnection.executeUpdate(sql, fabricante, modelo);

        showSaveResult(result);
    }

    private void saveInstrumento() throws SQLException {
        String fabricante = getFieldValue(0);
        String modelo = getFieldValue(1);

        String sql = "INSERT INTO Aviao (fabricante, modelo) VALUES (?, ?)";
        int result = DatabaseConnection.executeUpdate(sql, fabricante, modelo);

        showSaveResult(result);
    }

    private void savePlaneta() throws SQLException {
        String fabricante = getFieldValue(0);
        String modelo = getFieldValue(1);

        String sql = "INSERT INTO Aviao (fabricante, modelo) VALUES (?, ?)";
        int result = DatabaseConnection.executeUpdate(sql, fabricante, modelo);

        showSaveResult(result);
    }

    private void savePokemon() throws SQLException {
        String fabricante = getFieldValue(0);
        String modelo = getFieldValue(1);

        String sql = "INSERT INTO Aviao (fabricante, modelo) VALUES (?, ?)";
        int result = DatabaseConnection.executeUpdate(sql, fabricante, modelo);

        showSaveResult(result);
    }

    private void savePowerRanger() throws SQLException {
        String fabricante = getFieldValue(0);
        String modelo = getFieldValue(1);

        String sql = "INSERT INTO Aviao (fabricante, modelo) VALUES (?, ?)";
        int result = DatabaseConnection.executeUpdate(sql, fabricante, modelo);

        showSaveResult(result);
    }

    private void saveRoupa() throws SQLException {
        String fabricante = getFieldValue(0);
        String modelo = getFieldValue(1);

        String sql = "INSERT INTO Aviao (fabricante, modelo) VALUES (?, ?)";
        int result = DatabaseConnection.executeUpdate(sql, fabricante, modelo);

        showSaveResult(result);
    }

    private void saveVideoGame() throws SQLException {
        String fabricante = getFieldValue(0);
        String modelo = getFieldValue(1);

        String sql = "INSERT INTO Aviao (fabricante, modelo) VALUES (?, ?)";
        int result = DatabaseConnection.executeUpdate(sql, fabricante, modelo);

        showSaveResult(result);
    }

    private String getFieldValue(int index) {
        TextField field = (TextField) fieldsContainer.getChildren().get(index);
        return field.getText();
    }

    private void showSaveResult(int result) {
        if (result > 0) {
            showAlert("Sucesso", "Cadastro realizado com sucesso!");
        } else {
            showAlert("Erro", "Falha ao realizar o cadastro.");
        }
    }


    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
