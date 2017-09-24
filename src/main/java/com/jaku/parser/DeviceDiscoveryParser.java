package com.jaku.parser;

import com.jaku.core.Response;

public class DeviceDiscoveryParser extends JakuParser {

	@Override
	public Object parse(Response response) {
		return response.getData();
	}
}
