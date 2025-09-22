package com.wseemann.ecp.request;

import com.wseemann.ecp.parser.ECPResponseParser;
import org.jetbrains.annotations.NotNull;

final public class KeydownRequest extends KeyRequest {

	public KeydownRequest(String url, String key) {
		super(url, key);
	}
	
	@Override
	public @NotNull String getPath() {
		return "/keydown/" + getKey();
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
