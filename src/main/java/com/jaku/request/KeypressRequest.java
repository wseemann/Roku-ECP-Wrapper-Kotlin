package com.jaku.request;

import com.jaku.core.JakuRequestData;

public class KeypressRequest extends JakuRequestData {

	private String key;
	
	public KeypressRequest(String url, String key) {
		super(url);		
		this.key = key;
	}
	
	@Override
	public String getPath() {
		return "/keypress/" + key;
	}
	
	@Override
	public String getMethod() {
		return "POST";
	}
}
