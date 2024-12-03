package com.example.lp1;

import com.example.lp1.helpers.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String cssTelas = getClass().getResource("styleTelas.css").toExternalForm();
    private String css = getClass().getResource("style.css").toExternalForm();

    public void trocaAnimais(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SceneAnimal.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(cssTelas);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void trocaAviões(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SceneAviao.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(cssTelas);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void trocaCarros(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SceneCarro.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(cssTelas);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void trocaInstrumentos(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SceneInstrumento.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(cssTelas);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void trocaRoupas(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SceneRoupa.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(cssTelas);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void trocaPokemons(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ScenePokemon.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(cssTelas);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void trocaVideoGames(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SceneVG.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(cssTelas);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void trocaPowerRangers(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ScenePR.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(cssTelas);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void trocaPlanetas(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ScenePlaneta.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(cssTelas);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void trocaAparelhos(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SceneAparelho.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(cssTelas);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void trocaCadastro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cadastro.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(cssTelas);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void voltaMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(css);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void Exit(ActionEvent e) {
        System.exit(0);
    }


}
