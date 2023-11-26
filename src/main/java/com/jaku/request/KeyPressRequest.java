package com.jaku.request;

import com.jaku.core.JakuRequest;
import com.jaku.parser.JakuParser;

final public class KeyPressRequest extends JakuRequest<Void> {

	private final String key;
	
	public KeyPressRequest(String url, String key) {
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

	@Override
	public JakuParser<Void> getParser() {
		return null;
	}
}
