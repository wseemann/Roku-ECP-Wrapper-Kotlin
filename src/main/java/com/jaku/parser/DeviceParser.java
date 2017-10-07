package com.jaku.parser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.jaku.core.Response;
import com.jaku.model.Device;

public class DeviceParser extends JakuParser {

	@Override
	public Object parse(Response response) {
		Device device = new Device();

        if (response == null || response.getData() == null) {
            return device;
        }
		
        SAXBuilder builder = new SAXBuilder();

        Document document;
        try {
            document = (Document) builder.build(new StringReader(new String(((ByteArrayOutputStream) response.getData()).toByteArray())));
            Element rootNode = document.getRootElement();

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
            device.setDeveloperEnabled(checkValue(rootNode.getChild("developer-enabled")));
            device.setKeyedDeveloperId(checkValue(rootNode.getChild("keyed-developer-id")));
            device.setSearchEnabled(checkValue(rootNode.getChild("search-enabled")));
            device.setVoiceSearchEnabled(checkValue(rootNode.getChild("voice-search-enabled")));
            device.setNotificationsEnabled(checkValue(rootNode.getChild("notifications-enabled")));
            device.setNotificationsFirstUse(checkValue(rootNode.getChild("notifications-first-use")));
            device.setHeadphonesConnected(checkValue(rootNode.getChild("headphones-connected")));

        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return device;
	}
	
	private String checkValue(Element element) {
        if (element == null) {
            return null;
        }

        return element.getValue();
    }
}