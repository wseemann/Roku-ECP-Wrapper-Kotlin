package com.wseemann.ecp.parser;

import com.wseemann.ecp.api.QueryRequests;
import com.wseemann.ecp.model.Device;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class DeviceDiscoveryParser extends ECPResponseParser<List<Device>> {

	@Override
	public List<Device> parse(byte [] body) throws IOException {
		List<Device> devices = new ArrayList<>();

		if (body == null) {
			return devices;
		}

		String[] deviceIpAddresses = new String(body).split("\\|");

		for (String deviceIp : deviceIpAddresses) {
			Device device = QueryRequests.queryDeviceInfo("http://" + deviceIp + ":8060");
			device.setHost("http://" + deviceIp + ":8060");
			devices.add(device);
		}

		return devices;
	}
}
