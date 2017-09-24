package com.jaku.core;

public class JakuResponse {
	
	private Object jakuResponseData;
	
	public JakuResponse(Object jakuResponseData) {
		this.jakuResponseData = jakuResponseData;
	}

	public Object getResponseData() {
		return jakuResponseData;
	}

	public void setResponseData(JakuResponseData jakuResponseData) {
		this.jakuResponseData = jakuResponseData;
	}
}
