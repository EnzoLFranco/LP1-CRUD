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
import com.example.lp1.models.VideoGameModel;


public class VideoGameController extends HelloController {
    private String nome;
    private String genero;
    private int classificacaoEtaria;

    @FXML
    private Label info;
    @FXML
    private TextField nomeInput;
    @FXML
    private TableView<VideoGameModel> tableView;
    @FXML
    private TableColumn<VideoGameModel, String> nomeColumn;
    @FXML
    private TableColumn<VideoGameModel, String> generoColumn;
    @FXML
    private TableColumn<VideoGameModel, Integer> classificacaoColumn;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getClassificacaoEtaria() {
        return classificacaoEtaria;
    }
    public void setClassificacaoEtaria(int classificacaoEtaria) {
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public void initialize() {
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        generoColumn.setCellValueFactory(new PropertyValueFactory<>("genero"));
        classificacaoColumn.setCellValueFactory(new PropertyValueFactory<>("classificacaoEtaria"));

        carregarTabela();
    }

    private void carregarTabela() {
        List<VideoGameModel> videoGames = getVideoGamesDoBanco();

        tableView.getItems().clear();
        tableView.getItems().addAll(videoGames);
    }

    private List<VideoGameModel> getVideoGamesDoBanco() {
        List<VideoGameModel> videoGames = new ArrayList<>();
        String sql = "SELECT * FROM VideoGame";

        try (Connection conn = DatabaseConnection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {

            while (rs.next()) {
                String nome = rs.getString("nome");
                String genero = rs.getString("genero");
                int classificacaoEtaria = rs.getInt("classificacaoEtaria");

                VideoGameModel videoGame = new VideoGameModel(nome, genero, classificacaoEtaria);
                videoGames.add(videoGame);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return videoGames;
    }


    public void iniciar(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText("Iniciando " + nome + "...");
    }
    public void salvarProgresso(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText("Salvando seu progresso em " + nome + "!");
    }
    public void carregarProgresso(ActionEvent event) {
        nome = nomeInput.getText();
        info.setText("Carregando seu progresso em " + nome + "!");
    }
}
