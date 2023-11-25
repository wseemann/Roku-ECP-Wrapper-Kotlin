package com.jaku.parser;

import com.jaku.core.Response;

public abstract class JakuParser<T> {
	public abstract T parse(Response response);
}
