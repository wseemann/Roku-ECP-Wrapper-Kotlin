package com.jaku.core;

import java.io.IOException;

import com.jaku.parser.JakuParser;
import okhttp3.*;
import okhttp3.Request;
import org.jdom2.JDOMException;

public final class JakuRequest<T> {

	private static final String DISCOVERY = "DISCOVERY";

	private final JakuRequestData jakuRequestData;
	private final JakuParser<T> responseParser;

	public JakuRequest(JakuRequestData jakuRequestData) {
		this.jakuRequestData = jakuRequestData;
		this.responseParser = (JakuParser<T>) jakuRequestData.getParser();
	}
	
	public JakuResponse<T> send() throws IOException {
		String url = jakuRequestData.getEndpointUrl();

		try {
			if (jakuRequestData.getMethod().equalsIgnoreCase(DISCOVERY)) {
				com.jaku.core.Request request = new DiscoveryRequest(url);
				return new JakuResponse<>(generateResponseData(request.send().getData(), responseParser));
			} else {
				OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
				okHttpBuilder.setConnectTimeout$okhttp(6000);
				okHttpBuilder.setReadTimeout$okhttp(6000);
				OkHttpClient okHttpClient = okHttpBuilder.build();

				Request.Builder okHttpRequestBuilder = new okhttp3.Request.Builder()
						.addHeader("User-Agent", "Jaku");
				okHttpRequestBuilder.setUrl$okhttp(HttpUrl.parse(jakuRequestData.getEndpointUrl()));
				okHttpRequestBuilder.setMethod$okhttp(jakuRequestData.getMethod());
				Request request = okHttpRequestBuilder.build();

				Call call = okHttpClient.newCall(request);
				okhttp3.Response response = call.execute();

				ResponseBody responseBody = response.body();

				if (responseBody != null) {
					byte[] body = responseBody.bytes();
					// System.out.println("Request response: " + new String(body));
					return new JakuResponse<>(generateResponseData(body, responseParser));
				} else {
					return null;
				}
			}
		} catch (JDOMException ex) {
			throw new IOException();
		}
	}

	private T generateResponseData(byte [] body, JakuParser<T> parser) throws IOException, JDOMException {
		if (parser == null) {
			return null;
		}
		
		return parser.parse(body);
	}
}
