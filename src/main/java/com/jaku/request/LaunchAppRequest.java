package com.jaku.request;

import com.jaku.core.JakuRequest;
import com.jaku.parser.JakuParser;

final public class LaunchAppRequest extends JakuRequest<Void> {

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
	public JakuParser<Void> getParser() {
		return null;
	}
}
