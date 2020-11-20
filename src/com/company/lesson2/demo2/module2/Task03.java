package com.company.lesson2.demo2.module2;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 
 * Клиентский код
 *
 */
public class Task03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			// открываем сокет и коннектимся к localhost:3128
			// получаем сокет сервера
			while(true)
			{
				System.out.println("Please input string");
				String message = scanner.nextLine();
				Socket socket = new Socket("localhost", 9999);
				System.out.println("Client connected");

				OutputStream os = socket.getOutputStream();
				os.write(message.getBytes());
			}

		} catch (Exception e) {
			System.out.println("init error: " + e);
		} 
	}
}
