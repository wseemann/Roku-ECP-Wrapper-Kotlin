package com.jaku.core;

import java.io.IOException;

import com.jaku.parser.JakuParser;

public class JakuRequest {

	private JakuRequestData jakuRequestData;
	private JakuParser jakuParser;
	
	public JakuRequest(JakuRequestData piavaRequestData, JakuParser jakuParser) {
		this.jakuRequestData = piavaRequestData;
		this.jakuParser = jakuParser;
	}
	
	public JakuResponse send() throws IOException {
		JakuResponse jakuResponse = null;
		
		String url = jakuRequestData.getEndpointUrl();
		JakuParser parser = jakuParser;
		
		Request request = null;
		
		if (jakuRequestData.getMethod().equalsIgnoreCase("GET")) {
			request = new GETRequest(url);
		} else if(jakuRequestData.getMethod().equalsIgnoreCase("POST")) {
			request = new POSTRequest(url, "");
		} else {
			request = new GETRequest(url);
		}
		
		String response = request.send();
		
		if (jakuRequestData.getMethod().equalsIgnoreCase("GETALT")) {
			response = jakuRequestData.getEndpointUrl();
		}
		
		System.out.println("---> reponse" + response);
		
		jakuResponse = new JakuResponse(generateResponseData(response, parser));
		
		return jakuResponse;
	}
	
	private Object generateResponseData(String response, JakuParser parser) {
		if (parser == null) {
			return null;
		}
		
		return parser.parse(response);
	}
}
