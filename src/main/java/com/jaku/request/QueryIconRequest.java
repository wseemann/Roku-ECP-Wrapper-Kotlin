package com.jaku.request;

import com.jaku.core.JakuRequestData;

public class QueryIconRequest extends JakuRequestData {

	private String appId;
	
	public QueryIconRequest(String url, String appId) {
		super(url);
		this.appId = appId;
	}
	
	@Override
	public String getPath() {
		return "/query/icon/" + appId;
	}
	
	@Override
	public String getMethod() {
		return "GETALT";
	}
}
