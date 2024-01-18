package com.wseemann.ecp.request;

import com.wseemann.ecp.core.ECPRequest;
import com.wseemann.ecp.model.Device;
import com.wseemann.ecp.parser.DeviceParser;
import com.wseemann.ecp.parser.ECPResponseParser;
import org.jetbrains.annotations.NotNull;

final public class QueryDeviceInfoRequest extends ECPRequest<Device> {

	public QueryDeviceInfoRequest(String url) {
		super(url);		
	}

	@Override
	public @NotNull String getPath() {
		return "/query/device-info";
	}
	
	@Override
	public @NotNull String getMethod() {
		return "GET";
	}

	@Override
	public ECPResponseParser<Device> getParser() {
		return new DeviceParser(getUrl());
	}
}
