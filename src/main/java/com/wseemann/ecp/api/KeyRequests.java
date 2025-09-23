package com.wseemann.ecp.api;

import com.wseemann.ecp.core.KeyPressKeyValues;
import com.wseemann.ecp.request.KeydownRequest;
import com.wseemann.ecp.request.KeyPressRequest;
import com.wseemann.ecp.request.KeyupRequest;

public class KeyRequests {
	
	private KeyRequests() {
		
	}
	
	public static void keyPressRequest(String url, KeyPressKeyValues keyPressKeyValue) throws Exception {
		KeyPressRequest request = new KeyPressRequest(url, keyPressKeyValue.getValue());
		request.send();
	}
	
	public static void keyPressRequest(String url, char literalCharacter) throws Exception {
		KeyPressRequest request = new KeyPressRequest(url, KeyPressKeyValues.LIT_.getValue() + literalCharacter);
		request.send();
	}
	
	public static void keyPressRequest(String url, String word) throws Exception {
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
	
	public static void keyDownRequest(String url, KeyPressKeyValues keyPressKeyValue) throws Exception {
		KeydownRequest request = new KeydownRequest(url, keyPressKeyValue.getValue());
		request.send();
	}
	
	public static void keyUpRequest(String url, KeyPressKeyValues keyPressKeyValue) throws Exception {
		KeyupRequest request = new KeyupRequest(url, keyPressKeyValue.getValue());
		request.send();
	}
}
