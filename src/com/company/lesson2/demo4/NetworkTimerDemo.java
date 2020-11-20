package com.company.lesson2.demo4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.LocalTime;

public class NetworkTimerDemo {

	public static final int PORT = 10001;

	public static void main(String[] args) throws Exception {
		System.out.println("Timer is started");
		try(DatagramSocket datagramSocket = new DatagramSocket()){
			while (true){
				byte[] bytes = LocalTime.now().toString().getBytes();
				DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), PORT);
				datagramSocket.send(packet);
				Thread.sleep(1000);
			}
		}
	}
}
