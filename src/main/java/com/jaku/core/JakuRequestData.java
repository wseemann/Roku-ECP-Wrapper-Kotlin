package com.jaku.core;

import com.jaku.parser.JakuParser;

public abstract class JakuRequestData implements RequestParameters {

	private final String url;
	
	protected JakuRequestData(String url) {
		this.url = url;
	}
	
	public String getEndpointUrl() {
		return url + getPath();
	}

	public abstract JakuParser<?> getParser();
}
