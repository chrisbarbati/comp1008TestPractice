package com.example.testpractice;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BankController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}