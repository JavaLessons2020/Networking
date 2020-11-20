package com.company.lesson2.demo7;

import java.io.IOException;
import java.net.InetAddress;

public class InetAddressDemo {

	public static void main(String[] args) throws Exception {
		//InetAddress localhost = InetAddress.getLocalHost();
		//intetAddressInfo(localhost);
		InetAddress[] addrs = InetAddress.getAllByName("google.com.ua");
		for(InetAddress addr: addrs) {
			intetAddressInfo(addr);
		}
	}

	private static void intetAddressInfo(InetAddress addr) throws IOException {
		System.out.println("===================");
		System.out.println(addr);
		System.out.println("===================");
		//System.out.println(adress);
		System.out.println(addr.getCanonicalHostName());
		System.out.println(addr.getHostName());
		System.out.println(addr.getHostAddress());
		System.out.println();

//		addr = InetAddress.getByName("google.com");
//		System.out.println(addr.getCanonicalHostName());
//		System.out.println(addr.getHostName());
//		System.out.println(addr.getHostAddress());

	}

}
