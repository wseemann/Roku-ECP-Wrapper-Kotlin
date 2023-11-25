package com.jaku.api;

import java.io.IOException;
import java.util.List;

import com.jaku.core.JakuRequest;
import com.jaku.core.JakuResponse;
import com.jaku.model.Channel;
import com.jaku.model.Device;
import com.jaku.model.Player;
import com.jaku.request.*;

public class QueryRequests {
	
	private QueryRequests() {
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<Channel> queryAppsRequest(String url) throws IOException {
		QueryAppsRequest queryAppsRequest = new QueryAppsRequest(url);
		
		JakuRequest<List<Channel>> request = new JakuRequest<>(queryAppsRequest);
		JakuResponse<List<Channel>> response = request.send();
		
		return response.getResponseData();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Channel> queryActiveAppRequest(String url) throws IOException {
		QueryActiveAppRequest queryActiveAppRequest = new QueryActiveAppRequest(url);

		JakuRequest<List<Channel>> request = new JakuRequest<>(queryActiveAppRequest);
		JakuResponse<List<Channel>> response = request.send();
		
		return response.getResponseData();
	}
	
	public static Device queryDeviceInfo(String url) throws IOException {
		QueryDeviceInfoRequest queryActiveAppRequest = new QueryDeviceInfoRequest(url);
		
		JakuRequest<Device> request = new JakuRequest<>(queryActiveAppRequest);
		JakuResponse<Device> response = request.send();
		
		return response.getResponseData();
	}
	
	public static byte[] queryIconRequest(String url, String appId) throws IOException {
		QueryIconRequest queryActiveAppRequest = new QueryIconRequest(url, appId);
		
		JakuRequest<byte []> request = new JakuRequest<>(queryActiveAppRequest);
		JakuResponse<byte []> response = request.send();
		
		return response.getResponseData();
	}

	public static Player queryMediaPlayer(String url) throws IOException {
		QueryMediaPlayerRequest queryMediaPlayerRequest = new QueryMediaPlayerRequest(url);

		JakuRequest<Player> request = new JakuRequest<>(queryMediaPlayerRequest);
		JakuResponse<Player> response = request.send();

		return response.getResponseData();
	}
}
