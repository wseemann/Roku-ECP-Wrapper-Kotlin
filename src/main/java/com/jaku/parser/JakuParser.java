package com.jaku.parser;

import com.jaku.core.Response;

public abstract class JakuParser {
	public abstract Object parse(Response response);
}
