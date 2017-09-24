package com.jaku.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

public class POSTRequest extends Request {

	public POSTRequest(String url, String body) {
		super(url, body);
	}
	
	@Override
    public Response send() throws IOException {
    	HttpURLConnection conn = null;
        StringBuffer responseBody =  new StringBuffer();
        String line;
        BufferedReader reader = null;
        
        try {
        	URL uri = new URL(this.url);
        	
        	if (uri.getProtocol().equalsIgnoreCase("http")) {
        		conn = (HttpURLConnection) uri.openConnection();
        	} else {
        		conn = (HttpsURLConnection) uri.openConnection();
        	}
    	
    		conn.setRequestProperty("User-Agent", "Jaku");
    		conn.setConnectTimeout(6000);
    		conn.setReadTimeout(6000);
		    conn.setRequestMethod("POST");
		    conn.setDoOutput(true);
		    
		    byte[] out = body.getBytes(StandardCharsets.UTF_8);
		    int length = out.length;

		    conn.setFixedLengthStreamingMode(length);
		    conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		    conn.connect();
		    
		    try (OutputStream os = conn.getOutputStream()) {
		        os.write(out);
		    }
		    
		    reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    
		    while ((line = reader.readLine()) != null) {
		    	if (responseBody == null) {
		    		responseBody = new StringBuffer();
		    	}
		    	
		    	responseBody = responseBody.append(line);
            }
        } finally {
        	if (reader != null) {
        		reader.close();
        	}
        	
        	if (conn != null) {
        		conn.disconnect();
        	}
        }
        
        Response response = new Response();
        response.setBody(responseBody.toString());
        
        return response;
    }
}