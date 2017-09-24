package com.jaku.api;

import java.io.IOException;
import java.util.List;

import com.jaku.core.JakuRequest;
import com.jaku.core.JakuResponse;
import com.jaku.model.Device;
import com.jaku.parser.DeviceDiscoveryParser;
import com.jaku.request.DiscoveryRequest;

public class DeviceRequests {

	@SuppressWarnings("unchecked")
	public static final List<Device> discoverDevices() throws IOException {
		DiscoveryRequest discoveryRequest = new DiscoveryRequest("http://239.255.255.250:1900");
		
		JakuRequest request = new JakuRequest(discoveryRequest, new DeviceDiscoveryParser());
		JakuResponse response = request.send();
		
		return (List<Device>) response.getResponseData();
	}
}
