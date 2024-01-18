package com.wseemann.ecp.request;

import com.wseemann.ecp.core.ECPRequest;
import com.wseemann.ecp.parser.IconParser;
import com.wseemann.ecp.parser.ECPResponseParser;
import org.jetbrains.annotations.NotNull;

final public class QueryIconRequest extends ECPRequest<byte []> {

	private final String appId;
	
	public QueryIconRequest(String url, String appId) {
		super(url);
		this.appId = appId;
	}
	
	@Override
	public @NotNull String getPath() {
		return "/query/icon/" + appId;
	}
	
	@Override
	public @NotNull String getMethod() {
		return "GET";
	}


	@Override
	public ECPResponseParser<byte []> getParser() {
		return new IconParser();
	}
}
