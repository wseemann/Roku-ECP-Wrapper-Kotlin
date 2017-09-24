import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import com.jaku.api.KeyRequests;
import com.jaku.api.LaunchRequests;
import com.jaku.api.QueryRequests;
import com.jaku.core.KeypressKeyValues;
import com.jaku.model.Channel;
import com.jaku.model.Device;

public class JakuTest {

	private static final String ROKU_DEVICE_IP_ADDRESS = "<device ip address>";
	
	public static void main(String [] args) {		
		try {
			testKeypress();
			testKeydown();
			testKeyup();
			queryApps();
			queryActiveApp();
			queryDeviceInfo();
			launchAppId();
			queryIcon();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void testKeypress() throws IOException {
		KeyRequests.keypressRequest(ROKU_DEVICE_IP_ADDRESS, KeypressKeyValues.INFO);
	}
	
	private static void testKeydown() throws IOException {
		KeyRequests.keydownRequest(ROKU_DEVICE_IP_ADDRESS, KeypressKeyValues.INFO);
	}
	
	private static void testKeyup() throws IOException {
		KeyRequests.keyupRequest(ROKU_DEVICE_IP_ADDRESS, KeypressKeyValues.INFO);
	}
	
	private static void queryApps() throws IOException {
		List<Channel> channels = QueryRequests.queryAppsRequest(ROKU_DEVICE_IP_ADDRESS);
		
		for (Channel channel: channels) {
			System.out.println(channel.getId());
		}
	}
	
	private static void queryActiveApp() throws IOException {
		List<Channel> channels = QueryRequests.queryActiveAppRequest(ROKU_DEVICE_IP_ADDRESS);
		
		for (Channel channel: channels) {
			System.out.println(channel.getId());
		}
	}
	
	private static void queryDeviceInfo() throws IOException {
		Device device = QueryRequests.queryDeviceInfo(ROKU_DEVICE_IP_ADDRESS);
		
		System.out.println(device.getCountry());
	}
	
	private static void launchAppId() throws IOException {
		LaunchRequests.launchAppIdRequest(ROKU_DEVICE_IP_ADDRESS, "1457");
	}
	
	private static void queryIcon() throws IOException {
		BufferedImage bufferedImage = QueryRequests.queryIconRequest(ROKU_DEVICE_IP_ADDRESS, "1457");
		
		System.out.println(bufferedImage.getWidth());
		
		File outputfile = new File("<some path>");
	    ImageIO.write(bufferedImage, "jpeg", outputfile);
	}
}
