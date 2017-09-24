package com.jaku.request;

import com.jaku.core.JakuRequestData;

public class QueryAppsRequest extends JakuRequestData {

	public QueryAppsRequest(String url) {
		super(url);		
	}
	
	@Override
	public String getPath() {
		return "/query/apps";
	}
	
	@Override
	public String getMethod() {
		return "GET";
	}
}
