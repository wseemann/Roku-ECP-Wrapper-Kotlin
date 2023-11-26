package com.wseemann.ecp.api;

import java.io.IOException;

import com.wseemann.ecp.core.SearchTypeValues;
import com.wseemann.ecp.request.SearchRequest;

public class SearchRequests {

	private SearchRequests() {
		
	}
	
	public static void searchRequest(String url, String keyword, String title, SearchTypeValues type,
                                     String tmsId, Integer season, Boolean showUnavailable, Boolean matchAny,
                                     Long providerId, String provider, Boolean launch) throws IOException {
		SearchRequest request = new SearchRequest(url, keyword, title, type,
				tmsId, season, showUnavailable, matchAny, providerId, provider, launch);
		request.send();
	}
}
