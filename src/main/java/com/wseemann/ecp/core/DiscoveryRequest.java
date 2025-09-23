package com.wseemann.ecp.core;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class DiscoveryRequest extends Request {

	public DiscoveryRequest(String url) {
		super(url, null);
	}
	
	@Override
    public Response send() throws Exception {
        URL url = new URL(this.url);
        	
        String deviceIpAddresses = scanForAllRokus(url);
        
        Response response = new Response();
        response.setData(deviceIpAddresses.getBytes());
        return response;
    }
	
	private String scanForRoku(URL url) throws Exception {
		/* create byte arrays to hold our send and response data */
		byte[] sendData;
		byte[] receiveData = new byte[1024];

		/* our M-SEARCH data as a byte array */
		String MSEARCH = "M-SEARCH * HTTP/1.1\nHost: " + url.getHost() + ":" + url.getPort() + "\nMan: \"ssdp:discover\"\nST: roku:ecp\n"; 
		sendData = MSEARCH.getBytes();

		/* create a packet from our data destined for 239.255.255.250:1900 */
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName(url.getHost()), url.getPort());
		
		/* send packet to the socket we're creating */
		DatagramSocket clientSocket = new DatagramSocket();
		clientSocket.send(sendPacket);
		
		/* recieve response and store in our receivePacket */
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);

		/* get the response as a string */
		String response = new String(receivePacket.getData());

		/* close the socket */
		clientSocket.close();

		/* parse the IP from the response */
		/* the response should contain a line like:
			Location:  http://192.168.1.9:8060/
		   and we're only interested in the address -- not the port.
		   So we find the line, then split it at the http:// and the : to get the address.
		*/
		response = response.toLowerCase();
		/* return the IP */
		return response.split("location:")[1].split("\n")[0].split("http://")[1].split(":")[0].trim();
	}

	private String scanForAllRokus(URL url) throws Exception {
		List<String> deviceList = new ArrayList<String>();

		String address;

		for (int i = 0; i < 10; i++) {
			address = scanForRoku(url);
			if (!deviceList.contains(address)) {
				deviceList.add(address);
			}
		}

		StringBuilder stringBuffer = new StringBuilder();

		for (int i = 0; i < deviceList.size(); i++) {
			if (i != 0) {
				stringBuffer.append('|');
			}

			stringBuffer.append(deviceList.get(i));
		}

		return stringBuffer.toString();
	}
}