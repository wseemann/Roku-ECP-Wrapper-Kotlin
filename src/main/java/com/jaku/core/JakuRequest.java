package com.jaku.core;

import java.io.IOException;

import com.jaku.parser.JakuParser;

public final class JakuRequest<T> {

	private final JakuRequestData jakuRequestData;
	private final JakuParser<?> responseParser;

	public JakuRequest(JakuRequestData jakuRequestData) {
		this.jakuRequestData = jakuRequestData;
		this.responseParser = jakuRequestData.getParser();
	}
	
	public JakuResponse<T> send() throws IOException {
		String url = jakuRequestData.getEndpointUrl();
		
		Request request = null;
		
		if (jakuRequestData.getMethod().equalsIgnoreCase("GET")) {
			request = new GETRequest(url);
		} else if (jakuRequestData.getMethod().equalsIgnoreCase("POST")) {
			request = new POSTRequest(url, "");
		} else if (jakuRequestData.getMethod().equalsIgnoreCase("DISCOVERY")) {
			request = new DiscoveryRequest(url);
		}

		if (request == null) {
			throw new IOException("Invalid HTTP method:" + jakuRequestData.getMethod());
		}

		Response response = request.send();
		
		// System.out.println("Request response: " + response.getData());
		
		return new JakuResponse<>(generateResponseData(response, (JakuParser<T>) responseParser));
	}

	private T generateResponseData(Response response, JakuParser<T> parser) {
		if (parser == null) {
			return null; //response.getData();
		}
		
		return parser.parse(response);
	}
}
