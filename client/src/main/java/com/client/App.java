package com.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.*;
import java.io.FileWriter;
import java.io.FileReader;


public final class App {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username : ");
        String username = scanner.nextLine();
        System.out.println("Enter hostname : ");
        String hostnameserver = scanner.nextLine();
        // scanner.close();
        
        JSONObject username_json = new JSONObject();
        JSONArray arr = new JSONArray(); 
        List arr1 = new ArrayList();  
        username_json.put("username", username);
        String hostname = InetAddress.getLocalHost().getHostName();
        username_json.put("hostname", hostname);
        // arr.add(username);
        // arr1.add(username);
        // System.out.println(arr1);
        // FileWriter file = new FileWriter("C:/cours/chatbot/output.json");
        // file.write(username_json.toString());
        // file.close();
        // FileReader jsonO = new FileReader("C:/cours/chatbot/output.json");
        // String test =username_json.getJSONObject("liste").getString(username);
        // System.out.println(test);

        try {
            Socket s = new Socket(hostnameserver, 5000);
            PrintWriter username_send = new PrintWriter(s.getOutputStream());
            username_send.println(username_json);
            username_send.flush();
            String test = scanner.nextLine();
            JSONObject msg = new JSONObject();
            msg.put("private", test);
            PrintWriter test1 = new PrintWriter(s.getOutputStream());
            test1.println(msg);
            test1.flush();
            
            
            s.close();
        } catch (ConnectException e) {
            System.out.println("Error : Serveur doesn't exist or is offline !");
        } catch (UnknownHostException e) {
            System.out.println("Error : Wrong hostname !");
        }
    }
}
