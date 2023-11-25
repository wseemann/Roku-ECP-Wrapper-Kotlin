package com.jaku.parser;

import com.jaku.api.QueryRequests;
import com.jaku.model.Device;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class DeviceDiscoveryParser extends JakuParser<List<Device>> {

	@Override
	public List<Device> parse(byte [] body) {
		List<Device> devices = new ArrayList<>();

		if (body == null) {
			return devices;
		}

		try {
			String[] deviceIpAddresses = new String(body).split("\\|");

			for (String deviceIp : deviceIpAddresses) {
				Device device = QueryRequests.queryDeviceInfo("http://" + deviceIp + ":8060");
				device.setHost("http://" + deviceIp + ":8060");
				devices.add(device);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return devices;
	}
}
