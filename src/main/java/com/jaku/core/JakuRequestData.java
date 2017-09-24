package com.jaku.core;

import java.util.LinkedHashMap;

public abstract class JakuRequestData implements RequestParameters {

	private String url;
	
	protected JakuRequestData(String url) {
		this.url = url;
	}
	
	public LinkedHashMap<String, String> getQueryParameters() {
		return new LinkedHashMap<String, String>();
	}
	
	public String getEndpointUrl() {
		return url + getPath();
	}
}
