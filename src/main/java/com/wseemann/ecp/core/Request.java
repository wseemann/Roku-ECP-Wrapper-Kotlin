package com.wseemann.ecp.core;

import java.io.IOException;

public abstract class Request {

	protected final String url;
	protected final String body;
	
	public Request(String url, String body) {
		this.url = url;
		this.body = body;
	}
	
	public abstract Response send() throws IOException;	
}
