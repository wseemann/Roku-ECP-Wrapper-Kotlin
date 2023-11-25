package com.jaku.parser;

import org.jdom2.JDOMException;

import java.io.IOException;

public abstract class JakuParser<T> {
	public abstract T parse(byte [] body) throws IOException, JDOMException;
}
