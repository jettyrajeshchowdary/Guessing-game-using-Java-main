package com.example.day1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class guessingGame extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(guessingGame.class.getResource("gameView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),550,400);
        stage.setTitle("Guessing Game");
        stage.setResizable(false);
        stage.getIcons().add(new Image("flat-thinking-man-vector-29534016.jpg"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}