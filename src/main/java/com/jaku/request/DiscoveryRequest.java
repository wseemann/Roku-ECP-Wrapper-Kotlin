package com.jaku.request;

import com.jaku.core.JakuRequestData;
import com.jaku.parser.DeviceDiscoveryParser;
import com.jaku.parser.JakuParser;

final public class DiscoveryRequest extends JakuRequestData {

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
	public JakuParser<?> getParser() {
		return new DeviceDiscoveryParser();
	}
}
