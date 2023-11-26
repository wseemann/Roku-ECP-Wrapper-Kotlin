package com.wseemann.ecp.request;

import com.wseemann.ecp.core.ECPRequest;
import com.wseemann.ecp.parser.ECPResponseParser;

final public class LaunchAppRequest extends ECPRequest<Void> {

	private final String appId;
	
	public LaunchAppRequest(String url, String appId) {
		super(url);		
		this.appId = appId;
	}
	
	@Override
	public String getPath() {
		return "/launch/" + appId;
	}

	@Override
	public String getMethod() {
		return "POST";
	}

	@Override
	public ECPResponseParser<Void> getParser() {
		return null;
	}
}
