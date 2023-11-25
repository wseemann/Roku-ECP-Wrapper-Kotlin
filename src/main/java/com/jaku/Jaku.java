package com.jaku;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jaku.api.*;
import com.jaku.core.KeypressKeyValues;
import com.jaku.model.Channel;
import com.jaku.model.Device;

import javax.imageio.ImageIO;

public class Jaku {

	private static final String ROKU_DEVICE_IP_ADDRESS = "http://192.168.0.18:8060";
    private static RokuDevice rokuDevice;

	public static void main(String [] args) {
		try {
			DeviceRequests.discoverDevices();

			RokuDeviceFactory rokuDeviceFactory = new RokuDeviceFactoryImpl();
			rokuDevice = rokuDeviceFactory.create(ROKU_DEVICE_IP_ADDRESS);

			testKeypress();
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

	private static void testKeypress() throws IOException {
		rokuDevice.keyPressRequest(KeypressKeyValues.INFO);
	}

	private static void testKeydown() throws IOException {
		rokuDevice.keyDownRequest(KeypressKeyValues.INFO);
	}

	private static void testKeyup() throws IOException {
		rokuDevice.keyUpRequest(KeypressKeyValues.INFO);
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

		File outputfile = new File("<some path>");
		BufferedImage image = ImageIO.read( new ByteArrayInputStream(data));
		ImageIO.write(image, "png", outputfile);
	}
}
