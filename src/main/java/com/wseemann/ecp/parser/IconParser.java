package com.wseemann.ecp.parser;

public final class IconParser extends ECPResponseParser<byte []> {

	@Override
	public byte [] parse(byte [] body) {
        return body;
	}
}
