package com.example.client;

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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    String nickname;

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
        Stage stage = (Stage) disconnectButton.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();
        Scene previousScene = new Scene(root);

        stage.setScene(previousScene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> userList = new ArrayList<>();
        userList.add("Thomas");
        userList.add("Gabi");
        userList.add("Kevin");
        userList.add("Camille");
        userList.add("Colombe");

        for (String user: userList) {
            usersListView.getItems().add(user);
        }


    }
}
