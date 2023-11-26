package com.jaku.api;

import java.io.IOException;

import com.jaku.core.KeyPressKeyValues;
import com.jaku.request.KeydownRequest;
import com.jaku.request.KeyPressRequest;
import com.jaku.request.KeyupRequest;

public class KeyRequests {
	
	private KeyRequests() {
		
	}
	
	public static void keyPressRequest(String url, KeyPressKeyValues keyPressKeyValue) throws IOException {
		KeyPressRequest request = new KeyPressRequest(url, keyPressKeyValue.getValue());
		request.send();
	}
	
	public static void keyPressRequest(String url, char literalCharacter) throws IOException {
		KeyPressRequest request = new KeyPressRequest(url, KeyPressKeyValues.LIT_.getValue() + literalCharacter);
		request.send();
	}
	
	public static void keyPressRequest(String url, String word) throws IOException, InterruptedException {
		for (int i = 0; i < word.length(); i++) {
			KeyPressRequest request;
			
			if (word.charAt(i) != ' ') {
				request = new KeyPressRequest(url, KeyPressKeyValues.LIT_.getValue() + word.charAt(i));
			} else {
				request = new KeyPressRequest(url, KeyPressKeyValues.LIT_.getValue() + '+');
			}
			request.send();
			
			Thread.sleep(100);
		}
	}
	
	public static void keyDownRequest(String url, KeyPressKeyValues keyPressKeyValue) throws IOException {
		KeydownRequest request = new KeydownRequest(url, keyPressKeyValue.getValue());
		request.send();
	}
	
	public static void keyUpRequest(String url, KeyPressKeyValues keyPressKeyValue) throws IOException {
		KeyupRequest request = new KeyupRequest(url, keyPressKeyValue.getValue());
		request.send();
	}
}
