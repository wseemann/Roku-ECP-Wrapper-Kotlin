package com.jaku.request;

import com.jaku.core.JakuRequestData;
import com.jaku.parser.IconParser;
import com.jaku.parser.JakuParser;

final public class QueryIconRequest extends JakuRequestData {

	private final String appId;
	
	public QueryIconRequest(String url, String appId) {
		super(url);
		this.appId = appId;
	}
	
	@Override
	public String getPath() {
		return "/query/icon/" + appId;
	}
	
	@Override
	public String getMethod() {
		return "GET";
	}


	@Override
	public JakuParser<?> getParser() {
		return new IconParser();
	}
}
