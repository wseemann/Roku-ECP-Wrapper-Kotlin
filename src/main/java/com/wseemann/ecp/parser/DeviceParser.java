package com.wseemann.ecp.parser;

import java.io.IOException;
import java.io.StringReader;

import com.wseemann.ecp.model.Device;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public final class DeviceParser extends ECPResponseParser<Device> {

    private final String host;

    public DeviceParser(String host) {
        this.host = host;
    }

	@Override
	public Device parse(byte [] body) throws IOException, JDOMException {
		Device device = new Device();

        if (body == null) {
            return device;
        }
		
        SAXBuilder builder = new SAXBuilder();

        Document document = builder.build(new StringReader(new String(body)));
        Element rootNode = document.getRootElement();

        device.setHost(host);
        device.setUdn(checkValue(rootNode.getChild("udn")));
        device.setSerialNumber(checkValue(rootNode.getChild("serial-number")));
        device.setDeviceId(checkValue(rootNode.getChild("device-id")));
        device.setVendorName(checkValue(rootNode.getChild("vendor-name")));
        device.setModelNumber(checkValue(rootNode.getChild("model-number")));
        device.setModelName(checkValue(rootNode.getChild("model-name")));
        device.setWifiMac(checkValue(rootNode.getChild("wifi-mac")));
        device.setEthernetMac(checkValue(rootNode.getChild("ethernet-mac")));
        device.setNetworkType(checkValue(rootNode.getChild("network-type")));
        device.setUserDeviceName(checkValue(rootNode.getChild("user-device-name")));
        device.setSoftwareVersion(checkValue(rootNode.getChild("software-version")));
        device.setSoftwareBuild(checkValue(rootNode.getChild("software-build")));
        device.setSecureDevice(checkValue(rootNode.getChild("secure-device")));
        device.setLanguage(checkValue(rootNode.getChild("language")));
        device.setCountry(checkValue(rootNode.getChild("country")));
        device.setLocale(checkValue(rootNode.getChild("locale")));
        device.setTimeZone(checkValue(rootNode.getChild("time-zone")));
        device.setTimeZoneOffset(checkValue(rootNode.getChild("time-zone-offset")));
        device.setPowerMode(checkValue(rootNode.getChild("power-mode")));
        device.setSupportsSuspend(checkValue(rootNode.getChild("supports-suspend")));
        device.setSupportsFindRemote(checkValue(rootNode.getChild("supports-find-remote")));
        device.setSupportsAudioGuide(checkValue(rootNode.getChild("supports-audio-guide")));
        device.setDeveloperEnabled(checkValue(rootNode.getChild("developer-enabled")));
        device.setKeyedDeveloperId(checkValue(rootNode.getChild("keyed-developer-id")));
        device.setSearchEnabled(checkValue(rootNode.getChild("search-enabled")));
        device.setVoiceSearchEnabled(checkValue(rootNode.getChild("voice-search-enabled")));
        device.setNotificationsEnabled(checkValue(rootNode.getChild("notifications-enabled")));
        device.setNotificationsFirstUse(checkValue(rootNode.getChild("notifications-first-use")));
        device.setSupportsPrivateListening(checkValue(rootNode.getChild("supports-private-listening")));
        device.setHeadphonesConnected(checkValue(rootNode.getChild("headphones-connected")));
        device.setTv(checkValue(rootNode.getChild("is-tv")));
        device.setStick(checkValue(rootNode.getChild("is-stick")));

        return device;
	}
	
	private String checkValue(Element element) {
        if (element == null) {
            return null;
        }

        return element.getValue();
    }
}