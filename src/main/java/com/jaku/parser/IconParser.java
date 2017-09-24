package com.jaku.parser;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.jaku.core.Response;

public class IconParser extends JakuParser {

	@Override
	public Object parse(Response response) {
		BufferedImage bufferedImage = null;
		
		try {
			bufferedImage = ImageIO.read(new URL(response.getBody()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bufferedImage;
	}	
}
