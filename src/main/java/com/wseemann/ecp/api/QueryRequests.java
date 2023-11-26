package com.wseemann.ecp.api;

import java.io.IOException;
import java.util.List;

import com.wseemann.ecp.core.ECPResponse;
import com.wseemann.ecp.model.Channel;
import com.wseemann.ecp.model.Device;
import com.wseemann.ecp.model.Player;
import com.wseemann.ecp.request.*;

public class QueryRequests {
	
	private QueryRequests() {
		
	}
	
	public static List<Channel> queryAppsRequest(String url) throws IOException {
		QueryAppsRequest request = new QueryAppsRequest(url);
		ECPResponse<List<Channel>> response = request.send();

		return response.getResponseData();
	}
	
	public static List<Channel> queryActiveAppRequest(String url) throws IOException {
		QueryActiveAppRequest request = new QueryActiveAppRequest(url);
		ECPResponse<List<Channel>> response = request.send();
		
		return response.getResponseData();
	}
	
	public static Device queryDeviceInfo(String url) throws IOException {
		QueryDeviceInfoRequest request = new QueryDeviceInfoRequest(url);
		ECPResponse<Device> response = request.send();
		
		return response.getResponseData();
	}
	
	public static byte[] queryIconRequest(String url, String appId) throws IOException {
		QueryIconRequest request = new QueryIconRequest(url, appId);
		ECPResponse<byte []> response = request.send();
		
		return response.getResponseData();
	}

	public static Player queryMediaPlayer(String url) throws IOException {
		QueryMediaPlayerRequest request = new QueryMediaPlayerRequest(url);
		ECPResponse<Player> response = request.send();

		return response.getResponseData();
	}
}
