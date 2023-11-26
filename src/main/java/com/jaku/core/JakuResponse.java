package com.jaku.core;

public class JakuResponse<T> {
	
	private final T jakuResponseData;
	
	public JakuResponse(T jakuResponseData) {
		this.jakuResponseData = jakuResponseData;
	}

	public T getResponseData() {
		return jakuResponseData;
	}
}
