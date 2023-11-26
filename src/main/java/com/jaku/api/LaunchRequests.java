package com.jaku.api;

import java.io.IOException;

import com.jaku.request.LaunchAppRequest;

public class LaunchRequests {
	
	private LaunchRequests() {
		
	}
	
	public static void launchAppIdRequest(String url, String appId) throws IOException {
		LaunchAppRequest request = new LaunchAppRequest(url, appId);
		request.send();
	}
}
