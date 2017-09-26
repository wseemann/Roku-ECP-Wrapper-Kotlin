package com.jaku.request;

import com.jaku.core.JakuRequestData;

public class InstallRequest extends JakuRequestData {

	private String appId;
	
	public InstallRequest(String url, String appId) {
		super(url);
		this.appId = appId;
	}
	
	@Override
	public String getPath() {
		return "/install/" + appId;
	}
	
	@Override
	public String getMethod() {
		return "POST";
	}
}
