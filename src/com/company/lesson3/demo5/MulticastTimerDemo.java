package com.company.lesson3.demo5;

import com.company.lesson3.Server;

import java.net.*;

public class MulticastTimerDemo {

	public static void main(String[] args) throws Exception {



		MulticastSocket multicastSocket = new MulticastSocket(MulticastSenderDemo.MCADDRESS.getPort());

		//multicastSocket.joinGroup(MulticastSenderDemo.MCADDRESS.getAddress());
		DatagramPacket packet = new DatagramPacket(new byte[255], 255);
		for (int i = 0; i < 3; i++) {
			multicastSocket.receive(packet);
			System.out.println("Received from" + packet.getSocketAddress());
			System.out.println(new String(packet.getData(), packet.getOffset(), packet.getLength()));
		}
		//multicastSocket.leaveGroup(MulticastSenderDemo.MCADDRESS.getAddress());
	}

}
