package com.jaku.api;

import java.io.IOException;
import java.util.List;

import com.jaku.core.JakuResponse;
import com.jaku.model.Channel;
import com.jaku.model.Device;
import com.jaku.model.Player;
import com.jaku.request.*;

public class QueryRequests {
	
	private QueryRequests() {
		
	}
	
	public static List<Channel> queryAppsRequest(String url) throws IOException {
		QueryAppsRequest request = new QueryAppsRequest(url);
		JakuResponse<List<Channel>> response = request.send();

		return response.getResponseData();
	}
	
	public static List<Channel> queryActiveAppRequest(String url) throws IOException {
		QueryActiveAppRequest request = new QueryActiveAppRequest(url);
		JakuResponse<List<Channel>> response = request.send();
		
		return response.getResponseData();
	}
	
	public static Device queryDeviceInfo(String url) throws IOException {
		QueryDeviceInfoRequest request = new QueryDeviceInfoRequest(url);
		JakuResponse<Device> response = request.send();
		
		return response.getResponseData();
	}
	
	public static byte[] queryIconRequest(String url, String appId) throws IOException {
		QueryIconRequest request = new QueryIconRequest(url, appId);
		JakuResponse<byte []> response = request.send();
		
		return response.getResponseData();
	}

	public static Player queryMediaPlayer(String url) throws IOException {
		QueryMediaPlayerRequest request = new QueryMediaPlayerRequest(url);
		JakuResponse<Player> response = request.send();

		return response.getResponseData();
	}
}
