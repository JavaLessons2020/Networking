package com.company.lesson2.demo4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class NetworkClock {

    public static void main(String[] args) throws SocketException, InterruptedException {
        try (DatagramSocket socket = new DatagramSocket(NetworkTimerDemo.PORT)) {
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            while (true) {

                socket.receive(packet);
                System.out.println(new String(packet.getData(), packet.getOffset(), packet.getLength()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(1000);

    }

}
