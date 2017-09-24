package com.jaku.core;

public enum KeypressKeyValues {
	HOME("Home"),
	REV("Rev"),
	FWD("Fwd"),
	PLAY("Play"),
	SELECT("Select"),
	LEFT("Left"),
	RIGHT("Right"),
	DOWN("Down"),
	UP("Up"),
	BACK("Back"),
	INTANT_REPLAY("IntantReplay"),
	INFO("Info"),
	BACKSPACE("Backspace"),
	SEARCH("Search"),
	ENTER("Enter");

	private final String method;

	KeypressKeyValues(String method) {
		this.method = method;
	}

	public String getValue() {
		return method;
	}
}
