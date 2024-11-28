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
import com.example.lp1.models.InstrumentoModel;

public class InstrumentoController extends HelloController {
    private int IDInstrumento;
    private String nome;
    private int numeroCordas;

    @FXML
    private Label info;
    @FXML
    private TextField nomeInput;
    @FXML
    private TextField musicaInput;
    @FXML
    private TextField cordasInput;
    @FXML
    private TableView<InstrumentoModel> tableView;
    @FXML
    private TableColumn<InstrumentoModel, Integer> IDInstrumentoColumn;
    @FXML
    private TableColumn<InstrumentoModel, String> nomeColumn;
    @FXML
    private TableColumn<InstrumentoModel, Integer> numeroCordasColumn;

    public int getIDInstrumento() {
        return IDInstrumento;
    }
    public void setIDInstrumento(int IDIns) {
        this.IDInstrumento = IDIns;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNumeroCordas() {
        return numeroCordas;
    }
    public void setNumeroCordas(int numCordas) {
        this.numeroCordas = numCordas;
    }

    public void initialize() {
        IDInstrumentoColumn.setCellValueFactory(new PropertyValueFactory<>("IDInstrumento"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        numeroCordasColumn.setCellValueFactory(new PropertyValueFactory<>("numeroCordas"));

        carregarTabela();
    }

    private void carregarTabela() {
        List<InstrumentoModel> instrumentos = getInstrumentosDoBanco();

        tableView.getItems().clear();
        tableView.getItems().addAll(instrumentos);
    }

    private List<InstrumentoModel> getInstrumentosDoBanco() {
        List<InstrumentoModel> instrumentos = new ArrayList<>();
        String sql = "SELECT * FROM Instrumento";

        try (Connection conn = DatabaseConnection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {

            while (rs.next()) {
                int IDInstrumento = rs.getInt("IDInstrumento");
                String nome = rs.getString("nome");
                int numeroCordas = rs.getInt("numeroCordas");

                System.out.println("Instrumento encontrado: ID = " + IDInstrumento + ", Nome = " + nome + ", Cordas = " + numeroCordas);

                InstrumentoModel instrumento = new InstrumentoModel(IDInstrumento, nome, numeroCordas);
                instrumentos.add(instrumento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return instrumentos;
    }

public void tocar(ActionEvent event) {
    nome = nomeInput.getText();
    String musica = musicaInput.getText();
    info.setText("Você tocou a música " + musica + " no " + nome);
}
public void afinar(ActionEvent event) {
    nome = nomeInput.getText();
    info.setText("Você afinou seu " + nome + "!");
}
public void trocarCordas(ActionEvent event) {
    String nome = nomeInput.getText();
    int numTrocado = Integer.parseInt(cordasInput.getText());
    info.setText("Você trocou " + numTrocado + " cordas do seu " + nome + "!");
}
}
