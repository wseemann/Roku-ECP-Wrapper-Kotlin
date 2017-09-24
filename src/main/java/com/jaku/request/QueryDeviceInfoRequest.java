package com.jaku.request;

import com.jaku.core.JakuRequestData;

public class QueryDeviceInfoRequest extends JakuRequestData {

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
}
