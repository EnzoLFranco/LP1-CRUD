package com.example.lp1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader menu = new FXMLLoader(HelloApplication.class.getResource("Menu.fxml"));

        Scene menu1 = new Scene(menu.load(), 320, 240);

        String css = HelloApplication.class.getResource("style.css").toExternalForm();
        String cssTelas = HelloApplication.class.getResource("styleTelas.css").toExternalForm();

        menu1.getStylesheets().add(css);

        stage.setTitle("Classe's Menu");
        stage.setScene(menu1);
        stage.setWidth(620);
        stage.setHeight(450);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}