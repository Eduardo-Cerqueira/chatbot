package com.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public final class App extends Thread {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[-] Enter hostname : ");
        String hostnameserver = scanner.nextLine();
        
        Socket client_socket = new Socket(hostnameserver, 5000);
        PrintWriter out = new PrintWriter(client_socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
            
        System.out.println("[+] Vous avez rejoint le Canal Public :");
        String message;

        while (true) {
            System.out.println(in.readLine());
            message = scanner.nextLine();
            
            out.println(message);
            out.flush();

            if (message == "bye") {
                break;
            }
        }
        scanner.close();
        client_socket.close();
    }
}
