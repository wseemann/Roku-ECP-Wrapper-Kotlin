package com.jaku.api;

import java.io.IOException;

import com.jaku.core.JakuRequest;
import com.jaku.core.SearchTypeValues;
import com.jaku.request.SearchRequest;

public class SearchRequests {

	private SearchRequests() {
		
	}
	
	public static final void searchRequest(String url, String keyword, String title, SearchTypeValues type,
			String tmsid, Integer season, Boolean showUnavailable, Boolean matchAny,
			Long providerId, String provider, Boolean launch) throws IOException {
		SearchRequest searchRequest = new SearchRequest(url, keyword, title, type,
				tmsid, season, showUnavailable, matchAny, providerId, provider, launch);
		
		JakuRequest request = new JakuRequest(searchRequest, null);
		request.send();
	}
}
