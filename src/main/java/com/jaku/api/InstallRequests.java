package com.jaku.api;

import java.io.IOException;

import com.jaku.request.InstallRequest;

public class InstallRequests {

	private InstallRequests() {
		
	}
	
	public static void installRequest(String url, String appId) throws IOException {
		InstallRequest request = new InstallRequest(url, appId);
		request.send();
	}
}
