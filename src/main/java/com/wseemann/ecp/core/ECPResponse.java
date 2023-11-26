package com.wseemann.ecp.core;

public class ECPResponse<T> {
	
	private final T responseData;
	
	public ECPResponse(T responseData) {
		this.responseData = responseData;
	}

	public T getResponseData() {
		return responseData;
	}
}
