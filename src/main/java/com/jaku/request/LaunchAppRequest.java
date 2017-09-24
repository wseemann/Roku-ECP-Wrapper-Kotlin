package com.jaku.request;

import com.jaku.core.JakuRequestData;

public class LaunchAppRequest extends JakuRequestData {

	private String appId;
	
	public LaunchAppRequest(String url, String appId) {
		super(url);		
		this.appId = appId;
	}
	
	@Override
	public String getPath() {
		return "/launch/" + appId;
	}

	@Override
	public String getMethod() {
		return "POST";
	}
}
