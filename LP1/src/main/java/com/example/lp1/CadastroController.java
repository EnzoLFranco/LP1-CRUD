package com.example.lp1;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import com.example.lp1.helpers.DatabaseConnection;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CadastroController extends HelloController {

    @FXML
    private ComboBox<String> objectSelector;

    @FXML
    private VBox fieldsContainer;

    @FXML
    private Button saveButton;

    private String css = getClass().getResource("style.css").toExternalForm();

    @FXML
    public void initialize() {
        objectSelector.setItems(FXCollections.observableArrayList(
                "Animal", "Aparelho", "Avião", "Carro", "Instrumento", "Planeta", "Pokemon", "Power Ranger", "Roupa", "VideoGame"
        ));

        objectSelector.setOnAction(event -> updateFields(objectSelector.getValue()));
    }

    private void updateFields(String selectedObject) {
        fieldsContainer.getChildren().clear();

        switch (selectedObject) {
            case "Animal":
                fieldsContainer.getChildren().addAll(
                        createTextField("Nome"),
                        createTextField("Espécie")
                );
                break;

            case "Aparelho":
                fieldsContainer.getChildren().addAll(
                        createTextField("Marca"),
                        createTextField("Tipo")
                );
                break;

            case "Avião":
                fieldsContainer.getChildren().addAll(
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
                        createTextField("Tipo"),
                        createTextField("Tamanho")
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
        String placa = getFieldValue(0);
        String marca = getFieldValue(1);
        String modelo = getFieldValue(2);

        String sql = "INSERT INTO Carro (placa, marca, modelo) VALUES (?, ?, ?)";
        int result = DatabaseConnection.executeUpdate(sql, placa, marca, modelo);

        showSaveResult(result);
    }

    private void saveInstrumento() throws SQLException {
        String nome = getFieldValue(0);
        int numeroCordas = Integer.parseInt(getFieldValue(1));

        String sql = "INSERT INTO Instrumento (nome, numeroCordas) VALUES (?, ?)";
        int result = DatabaseConnection.executeUpdate(sql, nome, numeroCordas);

        showSaveResult(result);
    }

    private void savePlaneta() throws SQLException {
        String nome = getFieldValue(0);
        float raio = Float.parseFloat(getFieldValue(1));
        String massa = getFieldValue(2);

        String sql = "INSERT INTO Planeta (nome, raio, massa) VALUES (?, ?, ?)";
        int result = DatabaseConnection.executeUpdate(sql, nome, raio, massa);

        showSaveResult(result);
    }

    private void savePokemon() throws SQLException {
        int numeroPokedex = Integer.parseInt(getFieldValue(0));
        String nome = getFieldValue(1);
        String tipos = getFieldValue(2);

        String sql = "INSERT INTO Pokemon (numeroPokedex, nome, tipos) VALUES (?, ?, ?)";
        int result = DatabaseConnection.executeUpdate(sql, numeroPokedex, nome, tipos);

        showSaveResult(result);
    }

    private void savePowerRanger() throws SQLException {
        String nome = getFieldValue(0);
        String corUniforme = getFieldValue(1);
        String zord = getFieldValue(2);

        String sql = "INSERT INTO PowerRanger (nome, corUniforme, zord) VALUES (?, ?, ?)";
        int result = DatabaseConnection.executeUpdate(sql, nome, corUniforme, zord);

        showSaveResult(result);
    }

    private void saveRoupa() throws SQLException {
        String tipo = getFieldValue(0);
        String tamanho = getFieldValue(1);

        String sql = "INSERT INTO Roupa (tipo, tamanho) VALUES (?, ?)";
        int result = DatabaseConnection.executeUpdate(sql, tipo, tamanho);

        showSaveResult(result);
    }

    private void saveVideoGame() throws SQLException {
        String nome = getFieldValue(0);
        String genero = getFieldValue(1);
        String classificacaoEtaria = getFieldValue(2);

        String sql = "INSERT INTO VideoGame (nome, genero, classificacaoEtaria) VALUES (?, ?)";
        int result = DatabaseConnection.executeUpdate(sql, nome, genero, classificacaoEtaria);

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

    public void voltaMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(css);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
