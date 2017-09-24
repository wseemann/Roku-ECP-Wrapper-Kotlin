package com.jaku.request;

import com.jaku.core.JakuRequestData;

public class KeyupRequest extends JakuRequestData {

	private String key;
	
	public KeyupRequest(String url, String key) {
		super(url);		
		this.key = key;
	}
	
	@Override
	public String getPath() {
		return "/keyup/" + key;
	}
	
	@Override
	public String getMethod() {
		return "POST";
	}
}
