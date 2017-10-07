package com.jaku.parser;

import com.jaku.core.Response;

public class IconParser extends JakuParser {

	@Override
	public Object parse(Response response) {
		if (response == null || response.getData() == null) {
			return null;
		}
		
		return response.getData();
	}
}
