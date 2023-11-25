package com.jaku.request;

import com.jaku.core.JakuRequestData;
import com.jaku.parser.AppsParser;
import com.jaku.parser.JakuParser;

final public class QueryAppsRequest extends JakuRequestData {

	public QueryAppsRequest(String url) {
		super(url);		
	}


	@Override
	public String getPath() {
		return "/query/apps";
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
