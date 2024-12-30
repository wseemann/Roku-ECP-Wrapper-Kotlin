package com.wseemann.ecp.request;

import com.wseemann.ecp.core.ECPRequest;
import com.wseemann.ecp.parser.ECPResponseParser;
import org.jetbrains.annotations.NotNull;

final public class KeydownRequest extends ECPRequest<Void> {

	private final String key;
	
	public KeydownRequest(String url, String key) {
		super(url, true);
		this.key = key;
	}
	
	@Override
	public @NotNull String getPath() {
		return "/keydown/" + key;
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
