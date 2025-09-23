package com.wseemann.ecp.parser;

public abstract class ECPResponseParser<T> {
	public abstract T parse(byte [] body) throws Exception;
}
