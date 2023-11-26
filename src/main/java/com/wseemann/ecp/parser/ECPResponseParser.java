package com.wseemann.ecp.parser;

import org.jdom2.JDOMException;

import java.io.IOException;

public abstract class ECPResponseParser<T> {
	public abstract T parse(byte [] body) throws IOException, JDOMException;
}
