package com.jaku.request;

import com.jaku.core.JakuRequestData;

public class QueryActiveAppRequest extends JakuRequestData {

	public QueryActiveAppRequest(String url) {
		super(url);		
	}
	
	@Override
	public String getPath() {
		return "/query/active-app";
	}
	
	@Override
	public String getMethod() {
		return "GET";
	}
}
