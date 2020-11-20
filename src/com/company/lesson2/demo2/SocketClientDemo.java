package com.company.lesson2.demo2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.time.LocalTime;

public class SocketClientDemo {
    public static void main(String[] args) throws Exception {
        InetAddress adress = InetAddress.getLocalHost();

        try (
                Socket echoSocket = new Socket(adress, EchoServerDemo.port);
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader
                        (new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader scanner = new BufferedReader
                        (new InputStreamReader(System.in));
                ){
            String userInput = in.readLine();
            System.out.println(userInput);

            while (true){
                System.out.println(">>>");
                userInput = scanner.readLine();
                if(userInput == null || userInput.equals("Bye")){
                    break;
                }
                //System.out.println(userInput);
                out.println(userInput);
            }
        }
    }
}
