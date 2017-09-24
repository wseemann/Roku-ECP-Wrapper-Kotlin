package com.jaku;

import java.io.IOException;

import com.jaku.api.DeviceRequests;

public class Jaku {

	public static void main(String [] args) throws IOException {
		System.out.println("Hello, this is Jaku");
		
        DeviceRequests.discoverDevices();
	}
}
