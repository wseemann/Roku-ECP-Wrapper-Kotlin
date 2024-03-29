package com.wseemann.ecp.request;

import com.wseemann.ecp.core.ECPRequest;
import com.wseemann.ecp.model.Device;
import com.wseemann.ecp.parser.DeviceDiscoveryParser;
import com.wseemann.ecp.parser.ECPResponseParser;
import org.jetbrains.annotations.NotNull;

import java.util.List;

final public class DiscoveryRequest extends ECPRequest<List<Device>> {

	public DiscoveryRequest(String url) {
		super(url);		
	}

	@Override
	public @NotNull String getPath() {
		return "";
	}

	@Override
	public @NotNull String getMethod() {
		return "DISCOVERY";
	}

	@Override
	public ECPResponseParser<List<Device>> getParser() {
		return new DeviceDiscoveryParser();
	}
}
