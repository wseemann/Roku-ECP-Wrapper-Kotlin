package com.jaku.request;

import com.jaku.core.JakuRequestData;

public class KeydownRequest extends JakuRequestData {

	private String key;
	
	public KeydownRequest(String url, String key) {
		super(url);		
		this.key = key;
	}
	
	@Override
	public String getPath() {
		return "/keydown/" + key;
	}

	@Override
	public String getMethod() {
		return "POST";
	}
}
