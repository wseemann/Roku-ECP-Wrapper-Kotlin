package com.jaku.api;

import java.io.IOException;

import com.jaku.core.JakuRequest;
import com.jaku.core.KeypressKeyValues;
import com.jaku.request.KeydownRequest;
import com.jaku.request.KeypressRequest;
import com.jaku.request.KeyupRequest;

public class KeyRequests {
	
	private KeyRequests() {
		
	}
	
	public static final void keypressRequest(String url, KeypressKeyValues keypressKeyValue) throws IOException {
		KeypressRequest keypressRequest = new KeypressRequest(url, keypressKeyValue.getValue());
		
		JakuRequest request = new JakuRequest(keypressRequest, null);
		request.send();
	}
	
	public static final void keydownRequest(String url, KeypressKeyValues keypressKeyValue) throws IOException {
		KeydownRequest keydownRequest = new KeydownRequest(url, keypressKeyValue.getValue());
		
		JakuRequest request = new JakuRequest(keydownRequest, null);
		request.send();
	}
	
	public static final void keyupRequest(String url, KeypressKeyValues keypressKeyValue) throws IOException {
		KeyupRequest keyupRequest = new KeyupRequest(url, keypressKeyValue.getValue());
		
		JakuRequest request = new JakuRequest(keyupRequest, null);
		request.send();
	}
}
