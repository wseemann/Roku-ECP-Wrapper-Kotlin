package com.jaku.request;

import com.jaku.core.JakuRequest;
import com.jaku.model.Channel;
import com.jaku.parser.AppsParser;
import com.jaku.parser.JakuParser;

import java.util.List;

final public class QueryAppsRequest extends JakuRequest<List<Channel>> {

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
	public JakuParser<List<Channel>> getParser() {
		return new AppsParser();
	}
}
