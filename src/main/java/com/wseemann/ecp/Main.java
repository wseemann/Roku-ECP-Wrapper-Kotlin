package com.wseemann.ecp;

import com.wseemann.ecp.api.DeviceRequests;

import java.io.IOException;

public class Main {

	public static void main(String [] args) throws IOException {
		System.out.println("Roku ECP Wrapper");

		DeviceRequests.discoverDevices();
	}
}