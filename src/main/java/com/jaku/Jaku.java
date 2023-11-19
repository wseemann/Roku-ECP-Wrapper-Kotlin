package com.jaku;

import java.io.IOException;

import com.jaku.api.DeviceRequests;

public class Jaku {

	public static void main(String [] args) throws IOException {
		System.out.println("Hello, this is Jaku");
		
        /*byte[] data = QueryRequests.queryIconRequest("http://192.168.1.103:8060", "1457");
		
        InputStream is = null;
        BufferedImage bufferedImage = null;
		
		try {
			is = new ByteArrayInputStream(data);
			bufferedImage = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(bufferedImage.getWidth());
		
		File outputfile = new File("/Users/wseemann/Desktop/poop.jpeg");
	    ImageIO.write(bufferedImage, "jpeg", outputfile);*/
		
        DeviceRequests.discoverDevices();
	    //KeyRequests.keypressRequest("http://192.168.1.103:8060", KeypressKeyValues.BACK);
        //SearchRequests.searchRequest("http://192.168.1.103:8060", "Lego", "lego", null, null, 1, false, true, null, null, true);
	}
}
