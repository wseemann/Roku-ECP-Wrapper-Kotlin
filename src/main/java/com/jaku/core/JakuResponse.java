package com.jaku.core;

public class JakuResponse<T> {
	
	private T jakuResponseData;
	
	public JakuResponse(T jakuResponseData) {
		this.jakuResponseData = jakuResponseData;
	}

	public T getResponseData() {
		return jakuResponseData;
	}

	public void setResponseData(T jakuResponseData) {
		this.jakuResponseData = jakuResponseData;
	}
}
