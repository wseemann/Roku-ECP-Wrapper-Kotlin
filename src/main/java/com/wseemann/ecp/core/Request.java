package com.wseemann.ecp.core;

public abstract class Request {

	protected final String url;
	protected final String body;
	
	public Request(String url, String body) {
		this.url = url;
		this.body = body;
	}
	
	public abstract Response send() throws Exception;
}
