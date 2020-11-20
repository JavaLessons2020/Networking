package com.company.lesson2.demo2.module2;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * Код сервера
 * 
 */
public class Task02 {
	public static void main(String[] args) throws IOException {
		int portNumber = 9999;
		ServerSocket serverSocket = new ServerSocket(portNumber);
		int nPort = serverSocket.getLocalPort();
		System.out.println("Server adress: "
				+ serverSocket.getInetAddress().getHostAddress());
		System.out.println("Local Port: " + nPort);

		while (true) {
			/*
			 * Метод accept приостанавливает работу вызвавшего потока до тех
			 * пор, пока клиентское приложение не установит канал связи с
			 * сервером.
			 */
			Socket socket = serverSocket.accept();
			InputStream is = socket.getInputStream();
			// проверка наличия байт в потоке
			if (is.available() > 0) {
				byte[] bytes = new byte[is.available()]; 
				is.read(bytes);
				String message = new String(bytes);
				System.out.println(message);
			}
		}
	}
}
