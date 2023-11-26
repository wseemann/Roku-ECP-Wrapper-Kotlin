package com.jaku.request;

import com.jaku.core.JakuRequest;
import com.jaku.model.Device;
import com.jaku.parser.DeviceParser;
import com.jaku.parser.JakuParser;

final public class QueryDeviceInfoRequest extends JakuRequest<Device> {

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
	public JakuParser<Device> getParser() {
		return new DeviceParser();
	}
}
