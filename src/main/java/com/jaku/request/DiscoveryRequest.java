package com.jaku.request;

import com.jaku.core.JakuRequest;
import com.jaku.model.Device;
import com.jaku.parser.DeviceDiscoveryParser;
import com.jaku.parser.JakuParser;

import java.util.List;

final public class DiscoveryRequest extends JakuRequest<List<Device>> {

	public DiscoveryRequest(String url) {
		super(url);		
	}

	@Override
	public String getPath() {
		return "";
	}

	@Override
	public String getMethod() {
		return "DISCOVERY";
	}

	@Override
	public JakuParser<List<Device>> getParser() {
		return new DeviceDiscoveryParser();
	}
}
