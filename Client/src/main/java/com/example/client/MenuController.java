package com.example.client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class MenuController {
    @FXML
    private Label nicknameLabel;

    @FXML
    private Button disconnectButton;
    String nickname;
    Socket client_socket = null;


    public void setNickname(String nickname) {
        this.nickname = nickname;
        nicknameLabel.setText("Hello " + nickname + " !");
    }

    public void redirectTo(String view) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(view));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) nicknameLabel.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void globalTchat() throws IOException {
    redirectTo("Chat.fxml");
    }
    @FXML
    protected void privateMessage() throws IOException {
        redirectTo("PrivateMessage.fxml");
    }
    @FXML
    protected void creationGroup() throws IOException {
        redirectTo("GroupCreation.fxml");
    }

    @FXML
    protected void disconnect() throws IOException {
        client_socket.close();
        Stage stage = (Stage) disconnectButton.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();
        Scene previousScene = new Scene(root);

        stage.setScene(previousScene);
        stage.show();
    }
}
