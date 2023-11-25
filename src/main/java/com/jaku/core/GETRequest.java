package com.jaku.core;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class GETRequest extends Request {

	public GETRequest(String url) {
		super(url, null);
	}
	
	@Override
    public Response send() throws IOException {
    	HttpURLConnection conn = null;
        BufferedReader reader = null;
        InputStream is;
        ByteArrayOutputStream os = null;
        int len = -1;
        
        try {
        	URL uri = new URL(this.url);
        	
    		conn = (HttpURLConnection) uri.openConnection();
    	
    		conn.setRequestProperty("User-Agent", "Jaku");
    		conn.setConnectTimeout(6000);
    		conn.setReadTimeout(6000);
		    conn.setRequestMethod("GET");
		    
		    is = conn.getInputStream();
		    conn.connect();

	        byte[] byteChunk = new byte[4096];
	        
	        while ((len = is.read(byteChunk)) > 0 ) {
	        	if (os == null) {
	        		os = new ByteArrayOutputStream();
	        	}
	        	
	        	os.write(byteChunk, 0, len);
	        }
        } finally {
            if (conn != null) {
        		conn.disconnect();
        	}
        }
        
        Response response = new Response();
        response.setData(os);
        
        return response;
    }
}