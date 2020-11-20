package com.company.lesson2.demo2.module2;

import com.company.lesson2.demo2.module2.model.MultiSocketServer;

import java.io.IOException;
import java.net.UnknownHostException;


/**
 * 
 * Многопоточный сервер
 *
 */
public class Task04 {
	public static void main(String[] args) {
		MultiSocketServer server = null;
		try {
			server = new MultiSocketServer(9999);
			server.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if (server != null ) server.finish();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
