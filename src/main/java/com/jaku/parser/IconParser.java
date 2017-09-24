package com.jaku.parser;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class IconParser extends JakuParser {

	@Override
	public Object parse(String response) {
		BufferedImage bufferedImage = null;
		
		try {
			bufferedImage = ImageIO.read(new URL(response));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bufferedImage;
	}	
}
