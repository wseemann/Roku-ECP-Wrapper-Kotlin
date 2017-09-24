package com.jaku.core;

import java.io.IOException;

public abstract class Request {

	protected String url;
	protected String body;
	
	public Request(String url, String body) {
		this.url = url;
		this.body = body;
	}
	
	public abstract String send() throws IOException;	
}
