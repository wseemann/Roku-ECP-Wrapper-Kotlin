package com.jaku.api;

import java.io.IOException;

import com.jaku.core.JakuRequest;
import com.jaku.request.LaunchAppRequest;

public class LaunchRequests {
	
	private LaunchRequests() {
		
	}
	
	public static void launchAppIdRequest(String url, String appId) throws IOException {
		LaunchAppRequest launchAppIdRequest = new LaunchAppRequest(url, appId);
		
		JakuRequest request = new JakuRequest(launchAppIdRequest);
		request.send();
	}
}
