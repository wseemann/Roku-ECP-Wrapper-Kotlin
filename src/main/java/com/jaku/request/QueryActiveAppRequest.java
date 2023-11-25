package com.jaku.request;

import com.jaku.core.JakuRequestData;
import com.jaku.parser.AppsParser;
import com.jaku.parser.JakuParser;

final public class QueryActiveAppRequest extends JakuRequestData {

	public QueryActiveAppRequest(String url) {
		super(url);		
	}

	@Override
	public String getPath() {
		return "/query/active-app";
	}
	
	@Override
	public String getMethod() {
		return "GET";
	}

	@Override
	public JakuParser<?> getParser() {
		return new AppsParser();
	}
}
