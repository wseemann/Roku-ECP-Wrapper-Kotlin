package com.jaku.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GETRequest extends Request {

	public GETRequest(String url) {
		super(url, null);
	}
	
	@Override
    public String send() throws IOException {
    	HttpURLConnection conn = null;
        StringBuffer response = null;
        String line;
        BufferedReader reader = null;
        
        try {
        	URL uri = new URL(this.url);
        	
    		conn = (HttpURLConnection) uri.openConnection();
    	
    		conn.setRequestProperty("User-Agent", "Jaku");
    		conn.setConnectTimeout(6000);
    		conn.setReadTimeout(6000);
		    conn.setRequestMethod("GET");
		    
		    reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    conn.connect();

		    while ((line = reader.readLine()) != null) {
		    	if (response == null) {
		    	    response = new StringBuffer();
		    	}
		    	
		    	response = response.append(line);
            }
        } finally {
        	if (reader != null) {
        		reader.close();
        	}
        	
        	if (conn != null) {
        		conn.disconnect();
        	}
        }
        
        return response.toString();
    }
}