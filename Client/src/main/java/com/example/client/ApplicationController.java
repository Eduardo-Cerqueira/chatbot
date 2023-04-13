package com.example.client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationController {
    @FXML
    private TextField nicknameField;

    @FXML
    private Label errorLabel;

    @FXML
    protected void login() throws IOException {
        if (!nicknameField.getText().isBlank() || !nicknameField.getText().isEmpty()){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        MenuController controller = loader.getController();
        controller.setNickname(nicknameField.getText());

        Stage stage = (Stage) nicknameField.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
    else{
        errorLabel.setText("Please enter a correct nickname..");
        errorLabel.setVisible(true);
        }
    }
}