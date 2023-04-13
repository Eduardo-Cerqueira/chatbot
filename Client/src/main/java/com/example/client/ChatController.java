package com.example.client;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    String nickname;
    Socket client_socket = null;

    @FXML
    private ListView chatListView;

    @FXML
    private TextField messageTextField;

    @FXML
    private Button sendButton;

    @FXML
    private Button disconnectButton;

    @FXML
    private Label nicknameLabel;

    @FXML
    private ListView usersListView;

    @FXML
    protected void sendMessage() {
        String message = messageTextField.getText();
        chatListView.getItems().add(nickname + " : " + message );
        messageTextField.clear();
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
        nicknameLabel.setText("Hello " + nickname + " !");
    }

    @FXML
    protected  void disconnect() throws IOException {
        client_socket.close();
        Stage stage = (Stage) disconnectButton.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();
        Scene previousScene = new Scene(root);

        stage.setScene(previousScene);
        stage.show();
    }

    @FXML
    protected void returnMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        MenuController controller = loader.getController();
        controller.setNickname(nicknameLabel.getText());

        Stage stage = (Stage) nicknameLabel.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HashMap<String, Socket> connectedClients = new HashMap<>();

        try {
            client_socket = new Socket("macbook-pro-de-admin.home", 5000);
            InputStreamReader inputStreamReader = new InputStreamReader(client_socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(client_socket.getOutputStream());
            PrintWriter printWriter = new PrintWriter(outputStreamWriter, true);

            new Thread(() -> {
                String message;
                try {
                    while ((message = bufferedReader.readLine()) != null) {
                        String finalMessage = message;
                        Platform.runLater(() -> chatListView.getItems().add(finalMessage));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
