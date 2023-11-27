package com.wseemann.ecp.request;

import com.wseemann.ecp.core.ECPRequest;
import com.wseemann.ecp.parser.ECPResponseParser;

final public class KeydownRequest extends ECPRequest<Void> {

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
	public ECPResponseParser<Void> getParser() {
		return null;
	}
}