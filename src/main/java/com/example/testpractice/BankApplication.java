package com.example.testpractice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class BankApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BankApplication.class.getResource("bank-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1475, 900);
        stage.setTitle("Bank Application");
        stage.getIcons().add(new Image("icon.png"));
        stage.setScene(scene);
        //stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}