package com.wseemann.ecp;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.wseemann.ecp.core.KeyPressKeyValues;
import com.wseemann.ecp.model.Channel;
import com.wseemann.ecp.model.Device;
import com.wseemann.ecp.api.DeviceRequests;
import com.wseemann.ecp.api.RokuDevice;

import javax.imageio.ImageIO;

public class Main {

	private static final String ROKU_DEVICE_IP_ADDRESS = "http://192.168.50.101:8060";
    private static RokuDevice rokuDevice;

	public static void main(String [] args) {
		try {
			List<RokuDevice> rokuDevices = DeviceRequests.discoverDevices();
			rokuDevice = RokuDevice.Companion.create(ROKU_DEVICE_IP_ADDRESS);

			testKeyPress();
			testKeydown();
			testKeyup();
			queryApps();
			queryActiveApp();
			queryDeviceInfo();
			launchAppId();
			queryIcon();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void testKeyPress() throws IOException {
		rokuDevice.keyPressRequest(KeyPressKeyValues.INFO);
	}

	private static void testKeydown() throws IOException {
		rokuDevice.keyDownRequest(KeyPressKeyValues.INFO);
	}

	private static void testKeyup() throws IOException {
		rokuDevice.keyUpRequest(KeyPressKeyValues.INFO);
	}

	private static void queryApps() throws IOException {
		List<Channel> channels = rokuDevice.queryAppsRequest();

		for (Channel channel: channels) {
			System.out.println(channel.getTitle());
		}
	}

	private static void queryActiveApp() throws IOException {
		List<Channel> channels = rokuDevice.queryActiveAppRequest();

		for (Channel channel: channels) {
			System.out.println(channel.getId());
		}
	}

	private static void queryDeviceInfo() throws IOException {
		Device device = rokuDevice.queryDeviceInfo();

		System.out.println(device.getCountry());
	}

	private static void launchAppId() throws IOException {
		rokuDevice.launchAppIdRequest("1457");
	}

	private static void queryIcon() throws IOException {
		byte [] data = rokuDevice.queryIconRequest("1457");

		if (data.length > 0) {
			File outputfile = new File("<some path>");
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(data));
			ImageIO.write(image, "png", outputfile);
		}
	}
}
