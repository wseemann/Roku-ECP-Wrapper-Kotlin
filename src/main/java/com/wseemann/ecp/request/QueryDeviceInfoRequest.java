package com.wseemann.ecp.request;

import com.wseemann.ecp.core.ECPRequest;
import com.wseemann.ecp.model.Device;
import com.wseemann.ecp.parser.DeviceParser;
import com.wseemann.ecp.parser.ECPResponseParser;

final public class QueryDeviceInfoRequest extends ECPRequest<Device> {

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
	public ECPResponseParser<Device> getParser() {
		return new DeviceParser();
	}
}
