package com.wseemann.ecp;

import com.wseemann.ecp.api.DeviceRequests;
import com.wseemann.ecp.api.RokuDevice;
import com.wseemann.ecp.logging.Logger;
import com.wseemann.ecp.model.Device;

import java.util.List;

public class Main {

	public static void main(String [] args) throws Exception {
		Logger.INSTANCE.setLogDebug(false);
		Logger.INSTANCE.info("--- Roku ECP Wrapper ---");

		List<RokuDevice> rokuDevices = DeviceRequests.discoverDevices();

		Logger.INSTANCE.info("Found " + rokuDevices.size() + " Roku device(s) on the current network");

		for (RokuDevice rokuDevice : rokuDevices) {
			Device device = rokuDevice.queryDeviceInfo();
			Logger.INSTANCE.info("Model: " + device.getModelName() + " - Host: " + device.getHost());
		}

		Logger.INSTANCE.info("------------------------");
	}
}