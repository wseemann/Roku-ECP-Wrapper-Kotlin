package com.wseemann.ecp;

import com.wseemann.ecp.api.DeviceRequests;
import com.wseemann.ecp.logging.Logger;

import java.io.IOException;

public class Main {

	public static void main(String [] args) throws IOException {
		Logger.INSTANCE.info("Roku ECP Wrapper");

		DeviceRequests.discoverDevices();
	}
}