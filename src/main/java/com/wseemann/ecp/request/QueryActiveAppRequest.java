package com.wseemann.ecp.request;

import com.wseemann.ecp.core.ECPRequest;
import com.wseemann.ecp.model.Channel;
import com.wseemann.ecp.parser.AppsParser;
import com.wseemann.ecp.parser.ECPResponseParser;

import java.util.List;

final public class QueryActiveAppRequest extends ECPRequest<List<Channel>> {

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
	public ECPResponseParser<List<Channel>> getParser() {
		return new AppsParser();
	}
}
