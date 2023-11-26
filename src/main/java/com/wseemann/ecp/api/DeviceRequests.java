package com.wseemann.ecp.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.wseemann.ecp.core.ECPResponse;
import com.wseemann.ecp.model.Device;
import com.wseemann.ecp.request.DiscoveryRequest;

public class DeviceRequests {

	public static List<RokuDevice> discoverDevices() throws IOException {
		List<RokuDevice> rokuDevices = new ArrayList<>();

		DiscoveryRequest request = new DiscoveryRequest("http://239.255.255.250:1900");
		ECPResponse<List<Device>> response = request.send();
		
		List<Device> devices = response.getResponseData();

		for (Device device: devices) {
			rokuDevices.add(RokuDevice.Companion.create(device.getHost()));
		}

		return rokuDevices;
	}
}
