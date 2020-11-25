package com.company.lesson3.demo5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.time.LocalTime;

public class MulticastSenderDemo {
	static final InetSocketAddress MCADDRESS = new InetSocketAddress("239.1.1.1", 12345);

	public static void main(String[] args) throws Exception {

		DatagramSocket datagramSocket = new DatagramSocket();
		datagramSocket.setBroadcast(true);

		while (true) {
			byte[] bytes = LocalTime.now().toString().getBytes();
			DatagramPacket packet = new DatagramPacket(bytes, bytes.length, MCADDRESS);
			datagramSocket.send(packet);
			Thread.sleep(3000);
		}
	}
}
