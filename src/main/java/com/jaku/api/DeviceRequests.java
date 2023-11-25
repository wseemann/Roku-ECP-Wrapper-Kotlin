package com.jaku.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jaku.core.JakuRequest;
import com.jaku.core.JakuResponse;
import com.jaku.model.Device;
import com.jaku.request.DiscoveryRequest;

public class DeviceRequests {

	public static List<RokuDevice> discoverDevices() throws IOException {
		RokuDeviceFactory rokuDeviceFactory = new RokuDeviceFactoryImpl();

		List<RokuDevice> rokuDevices = new ArrayList<>();

		DiscoveryRequest discoveryRequest = new DiscoveryRequest("http://239.255.255.250:1900");
		
		JakuRequest request = new JakuRequest(discoveryRequest);
		JakuResponse response = request.send();
		
		List<Device> devices = (List<Device>) response.getResponseData();

		for (Device device: devices) {
			rokuDevices.add(rokuDeviceFactory.create(device.getHost()));
		}

		return rokuDevices;
	}
}
