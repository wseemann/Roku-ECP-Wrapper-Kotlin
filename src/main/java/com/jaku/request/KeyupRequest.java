package com.jaku.request;

import com.jaku.core.JakuRequestData;
import com.jaku.parser.JakuParser;

final public class KeyupRequest extends JakuRequestData {

	private final String key;
	
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

	@Override
	public JakuParser<?> getParser() {
		return null;
	}
}
