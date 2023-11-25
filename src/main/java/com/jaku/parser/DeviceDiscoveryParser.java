package com.jaku.parser;

import com.jaku.api.QueryRequests;
import com.jaku.core.Response;
import com.jaku.model.Device;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class DeviceDiscoveryParser extends JakuParser<List<Device>> {

	@Override
	public List<Device> parse(Response response) {
		List<Device> devices = new ArrayList<>();

		if (response == null || response.getData() == null) {
			return devices;
		}

		try {
			String[] deviceIpAddresses = response.getData().toString().split("\\|");

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
