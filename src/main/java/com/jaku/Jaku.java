package com.jaku;

import java.io.IOException;

import com.jaku.api.DeviceRequests;
import com.jaku.api.SearchRequests;

public class Jaku {

	public static void main(String [] args) throws IOException {
		System.out.println("Hello, this is Jaku");
		
        DeviceRequests.discoverDevices();
        //SearchRequests.searchRequest("http://192.168.1.103:8060", "Lego", "lego", null, null, 1, false, true, null, null, true);;
	}
}
