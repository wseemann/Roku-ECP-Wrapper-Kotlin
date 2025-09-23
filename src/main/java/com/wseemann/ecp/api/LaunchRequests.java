package com.wseemann.ecp.api;

import com.wseemann.ecp.request.LaunchAppRequest;

public class LaunchRequests {
	
	private LaunchRequests() {
		
	}
	
	public static void launchAppIdRequest(String url, String appId) throws Exception {
		LaunchAppRequest request = new LaunchAppRequest(url, appId);
		request.send();
	}
}
