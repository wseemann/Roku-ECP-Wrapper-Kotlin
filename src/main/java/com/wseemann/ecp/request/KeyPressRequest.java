package com.wseemann.ecp.request;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.wseemann.ecp.core.ECPRequest;
import com.wseemann.ecp.parser.ECPResponseParser;
import org.jetbrains.annotations.NotNull;

final public class KeyPressRequest extends ECPRequest<Void> {

	private final String key;
	
	public KeyPressRequest(String url, String key) throws UnsupportedEncodingException {
		super(url);
		this.key = URLEncoder.encode(key, StandardCharsets.UTF_8.name());
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
