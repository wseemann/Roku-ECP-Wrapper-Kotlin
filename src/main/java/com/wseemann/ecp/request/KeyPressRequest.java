package com.wseemann.ecp.request;

import com.wseemann.ecp.core.ECPRequest;
import com.wseemann.ecp.parser.ECPResponseParser;
import org.jetbrains.annotations.NotNull;

final public class KeyPressRequest extends ECPRequest<Void> {

	private final String key;
	
	public KeyPressRequest(String url, String key) {
		super(url, true);
		this.key = key;
	}
	
	@Override
	public @NotNull String getPath() {
		return "/keypress/" + key;
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
