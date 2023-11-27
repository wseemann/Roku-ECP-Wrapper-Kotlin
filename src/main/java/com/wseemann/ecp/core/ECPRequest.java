package com.wseemann.ecp.core;

import java.io.IOException;

import com.wseemann.ecp.logging.Logger;
import com.wseemann.ecp.parser.ECPResponseParser;
import okhttp3.*;
import okhttp3.Request;
import org.jdom2.JDOMException;

public abstract class ECPRequest<T> {

	private static final String DISCOVERY = "DISCOVERY";

	private final String url;

	protected ECPRequest(String url) {
		this.url = url;
	}

	protected abstract String getMethod();
	protected abstract String getPath();

	protected abstract ECPResponseParser<T> getParser();

	public ECPResponse<T> send() throws IOException {
		String url = this.url + getPath();

		try {
			if (getMethod().equalsIgnoreCase(DISCOVERY)) {
				com.wseemann.ecp.core.Request request = new DiscoveryRequest(url);
				return new ECPResponse<>(generateResponseData(request.send().getData(), getParser()));
			} else {
				OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
				okHttpBuilder.setConnectTimeout$okhttp(6000);
				okHttpBuilder.setReadTimeout$okhttp(6000);
				OkHttpClient okHttpClient = okHttpBuilder.build();

				Request.Builder okHttpRequestBuilder = new okhttp3.Request.Builder()
						.addHeader("User-Agent", "Roku-ECP-Wrapper-Kotlin");
				okHttpRequestBuilder.setUrl$okhttp(HttpUrl.parse(url));
				okHttpRequestBuilder.setMethod$okhttp(getMethod());
				Request request = okHttpRequestBuilder.build();

				Call call = okHttpClient.newCall(request);
				okhttp3.Response response = call.execute();

				ResponseBody responseBody = response.body();

				if (responseBody != null) {
					byte[] body = responseBody.bytes();
					Logger.INSTANCE.debug("ECP request response: " + new String(body));
					return new ECPResponse<>(generateResponseData(body, getParser()));
				} else {
					return null;
				}
			}
		} catch (JDOMException ex) {
			throw new IOException();
		}
	}

	private T generateResponseData(byte [] body, ECPResponseParser<T> parser) throws IOException, JDOMException {
		if (parser == null) {
			return null;
		}
		
		return parser.parse(body);
	}
}
