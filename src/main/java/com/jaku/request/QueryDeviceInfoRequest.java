package com.jaku.request;

import com.jaku.core.JakuRequestData;
import com.jaku.parser.DeviceParser;
import com.jaku.parser.JakuParser;

final public class QueryDeviceInfoRequest extends JakuRequestData {

	public QueryDeviceInfoRequest(String url) {
		super(url);		
	}

	@Override
	public String getPath() {
		return "/query/device-info";
	}
	
	@Override
	public String getMethod() {
		return "GET";
	}

	@Override
	public JakuParser<?> getParser() {
		return new DeviceParser();
	}
}
