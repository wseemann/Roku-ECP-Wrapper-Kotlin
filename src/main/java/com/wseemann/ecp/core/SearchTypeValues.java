package com.wseemann.ecp.core;

public enum SearchTypeValues {
	MOVIE("movie"),
	TV_SHOW("tv-show"),
	PERSON("person"),
	CHANNEL("channel"),
	GAME("game");
	
	private final String value;

	SearchTypeValues(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}