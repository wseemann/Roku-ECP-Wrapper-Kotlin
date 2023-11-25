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
	
	public static void keypressRequest(String url, KeypressKeyValues keypressKeyValue) throws IOException {
		KeypressRequest keypressRequest = new KeypressRequest(url, keypressKeyValue.getValue());
		
		JakuRequest request = new JakuRequest(keypressRequest);
		request.send();
	}
	
	public static void keypressRequest(String url, char literalCharacter) throws IOException {
		KeypressRequest keypressRequest = new KeypressRequest(url, KeypressKeyValues.LIT_.getValue() + literalCharacter);
		
		JakuRequest request = new JakuRequest(keypressRequest);
		request.send();
	}
	
	public static void keypressRequest(String url, String word) throws IOException, InterruptedException {
		for (int i = 0; i < word.length(); i++) {
			KeypressRequest keypressRequest = null;
			
			if (word.charAt(i) != ' ') {
			    keypressRequest = new KeypressRequest(url, KeypressKeyValues.LIT_.getValue() + word.charAt(i));
			} else {
				keypressRequest = new KeypressRequest(url, KeypressKeyValues.LIT_.getValue() + '+');
			}
			    
			JakuRequest request = new JakuRequest(keypressRequest);
			request.send();
			
			Thread.sleep(100);
		}
	}
	
	public static void keydownRequest(String url, KeypressKeyValues keypressKeyValue) throws IOException {
		KeydownRequest keydownRequest = new KeydownRequest(url, keypressKeyValue.getValue());
		
		JakuRequest request = new JakuRequest(keydownRequest);
		request.send();
	}
	
	public static void keyupRequest(String url, KeypressKeyValues keypressKeyValue) throws IOException {
		KeyupRequest keyupRequest = new KeyupRequest(url, keypressKeyValue.getValue());
		
		JakuRequest request = new JakuRequest(keyupRequest);
		request.send();
	}
}
