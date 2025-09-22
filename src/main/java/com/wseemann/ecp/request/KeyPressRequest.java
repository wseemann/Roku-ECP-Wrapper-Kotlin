package com.wseemann.ecp.request;

import com.wseemann.ecp.parser.ECPResponseParser;
import org.jetbrains.annotations.NotNull;

final public class KeyPressRequest extends KeyRequest {

	public KeyPressRequest(String url, String key) {
		super(url, key);
	}
	
	@Override
	public @NotNull String getPath() {
		return "/keypress/" + getKey();
	}
	
	@Override
	public @NotNull String getMethod() {
		return "POST";
	}

	@Override
	public ECPResponseParser<Void> getParser() {
		return null;
	}
}
