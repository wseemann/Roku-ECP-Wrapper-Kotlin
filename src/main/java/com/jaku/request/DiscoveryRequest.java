package com.jaku.request;

import com.jaku.core.JakuRequestData;

public class DiscoveryRequest extends JakuRequestData {

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
}
