package com.wseemann.ecp.request;

import com.wseemann.ecp.core.ECPRequest;
import com.wseemann.ecp.model.Channel;
import com.wseemann.ecp.parser.AppsParser;
import com.wseemann.ecp.parser.ECPResponseParser;
import org.jetbrains.annotations.NotNull;

import java.util.List;

final public class QueryAppsRequest extends ECPRequest<List<Channel>> {

	public QueryAppsRequest(String url) {
		super(url);		
	}


	@Override
	public @NotNull String getPath() {
		return "/query/apps";
	}
	
	@Override
	public @NotNull String getMethod() {
		return "GET";
	}

	@Override
	public ECPResponseParser<List<Channel>> getParser() {
		return new AppsParser();
	}
}
