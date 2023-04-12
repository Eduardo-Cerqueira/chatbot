package com.example.client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ApplicationController {
    @FXML
    private TextField nicknameField;

    @FXML
    protected void login() throws IOException {
       /* Socket client_socket = new Socket(nicknameField.getText(), 5000);
        PrintWriter out = new PrintWriter(client_socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client_socket.getInputStream())); */

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Chat.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        ChatController controller = loader.getController();
        controller.setNickname(nicknameField.getText());

        Stage stage = (Stage) nicknameField.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}