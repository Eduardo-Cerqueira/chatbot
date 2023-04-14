/* 
package com.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class App {
    public static void main(String[] args)  {
        Socket client_socket;
        PrintWriter out;
        BufferedReader in;
        Scanner scanner = new Scanner(System.in);
        System.out.println("[-] Enter hostname : ");
        String hostname = scanner.nextLine();
        System.out.println("[-] Enter username : ");
        String username = scanner.nextLine();
        try {
            client_socket = new Socket(hostname, 5000);
            out = new PrintWriter(client_socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void run(Socket client_socket, BufferedReader in, PrintWriter out, String username, Scanner scanner) {
        receive(client_socket, in, out, username);
        send(scanner, out, username);
    }

    public void receive(Socket client_socket, BufferedReader in, PrintWriter out, String username) {
        while (true) {
            try {
                out = new PrintWriter(client_socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
                System.out.println("damn receive on");
                out.println(username);
                out.flush();
                //pas de getalias check
                System.out.println(in.readLine());
                String message = in.readLine();
                if (message == "//getAlias") {
                    out.println(username);
                    out.flush();
                } else {
                    System.out.println(message);
                }
            } catch (Exception e) {
                System.out.println("Error!");
                try {
                    client_socket.close();
                } catch (IOException err) {
                    System.out.println(err);
                }
                break;
            }
        }
    }

    public void send(Scanner scanner, PrintWriter out, String username) {
        while (true) {
            String message = scanner.nextLine();
            System.out.println(username + ':' + message);
            out.println(message);
            out.flush();
        }
    }
    
    public void run() {
        receive(client_socket, in, out, username);
        send(scanner, out, username);
    }
    
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[-] Enter hostname : ");
        String hostnameserver = scanner.nextLine();
        
        Socket client_socket = new Socket(hostnameserver, 5000);
        PrintWriter out = new PrintWriter(client_socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
        
        System.out.println("[-] Enter username : ");
        String username = scanner.nextLine();

        JSONObject username_json = new JSONObject();
        username_json.put("status", 200);
        username_json.put("request", "//username");
        username_json.put("username", username);

        out.println(username_json);
        out.flush();

        System.out.println("[+] Vous avez rejoint le Canal Public :");
        String message;
        
        while (true) {
            System.out.println(in.readLine());
            System.out.println("|-> ");
            message = scanner.nextLine();

            
            JSONObject message_json = new JSONObject();
            message_json.put("status", 200);
            message_json.put("message", message);
            
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
*/

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