package com.wseemann.ecp.request;

import com.wseemann.ecp.core.ECPRequest;
import com.wseemann.ecp.parser.ECPResponseParser;
import org.jetbrains.annotations.NotNull;

final public class InstallRequest extends ECPRequest<Void> {

	private final String appId;
	
	public InstallRequest(String url, String appId) {
		super(url);
		this.appId = appId;
	}
	
	@Override
	public @NotNull String getPath() {
		return "/install/" + appId;
	}
	
	@Override
	public @NotNull String getMethod() {
		return "POST";
	}

	@Override
	public ECPResponseParser<Void> getParser() {
		return null;
	}
}
