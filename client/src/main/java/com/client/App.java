package com.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import org.json.*;

public final class App {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username : ");
        String username = scanner.nextLine();
        System.out.println("Enter hostname : ");
        String hostnameserver = scanner.nextLine();
        scanner.close();
        
        JSONObject username_json = new JSONObject();
        username_json.put("username", username);
        String hostname = InetAddress.getLocalHost().getHostName();
        username_json.put("hostname", hostname);

        try {
            Socket s = new Socket(hostnameserver, 5000);
            PrintWriter username_send = new PrintWriter(s.getOutputStream());
            username_send.println(username_json);
            username_send.flush();
            s.close();
        } catch (ConnectException e) {
            System.out.println("Error : Serveur doesn't exist or is offline !");
        } catch (UnknownHostException e) {
            System.out.println("Error : Wrong hostname !");
        }
    }
}
