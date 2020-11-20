package com.company.lesson2.demo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;

public class EchoServerDemo {
    static final String host = "localhost";
    static final int port = 10000;

    public static void main(String[] args) throws Exception {
        try (
                ServerSocket server = new ServerSocket(EchoServerDemo.port);
                Socket clientSocket = server.accept();//получает доступ к клиенту
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            System.out.println("Connect at: " + clientSocket.getRemoteSocketAddress());
            out.println("Type Bye to exit");

            String line;
            while ((line = in.readLine())!=null){
                out.println(line);
                System.out.println(line);
                if(line.equals("Bye")){
                    break;
                }
            }
        }
    }
}
