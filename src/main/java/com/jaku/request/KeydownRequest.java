package com.jaku.request;

import com.jaku.core.JakuRequest;
import com.jaku.parser.JakuParser;

final public class KeydownRequest extends JakuRequest<Void> {

	private final String key;
	
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

	@Override
	public JakuParser<Void> getParser() {
		return null;
	}
}
