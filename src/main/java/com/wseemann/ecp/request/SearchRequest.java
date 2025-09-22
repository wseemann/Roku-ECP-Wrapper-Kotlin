package com.wseemann.ecp.request;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wseemann.ecp.core.ECPRequest;
import com.wseemann.ecp.core.SearchTypeValues;
import com.wseemann.ecp.parser.ECPResponseParser;
import org.jetbrains.annotations.NotNull;

final public class SearchRequest extends ECPRequest<Void> {

	private static final String KEYWORD = "keyword";
	private static final String TITLE = "title";
	private static final String TYPE = "type";
	private static final String TMSID = "tmsid";
	private static final String SEASON = "season";
	private static final String SHOW_UNAVAILABLE = "show-unavailable";
	private static final String MATCH_ANY = "match-any";
	private static final String PROVIDER_ID = "provider-id";	
	private static final String PROVIDER = "provider";
	private static final String LAUNCH = "launch";
	
	private final LinkedHashMap<String, Object> parameters = new LinkedHashMap<String, Object>();
	
	public SearchRequest(String url, String keyword, String title, SearchTypeValues type,
			String tmsid, Integer season, Boolean showUnavailable, Boolean matchAny,
			Long providerId, String provider, Boolean launch) {
		super(url);
		parameters.put(KEYWORD, keyword);
		parameters.put(TITLE, title);
		parameters.put(TYPE, type);
		parameters.put(TMSID, tmsid);
		parameters.put(SEASON, season);
		parameters.put(SHOW_UNAVAILABLE, showUnavailable);
		parameters.put(MATCH_ANY, matchAny);
		parameters.put(PROVIDER_ID, providerId);
		parameters.put(PROVIDER, provider);
		parameters.put(LAUNCH, launch);
	}
	
	@Override
	public @NotNull String getPath() throws UnsupportedEncodingException {
		StringBuilder queryParameters = new StringBuilder();
		
	    Iterator<Entry<String, Object>> it = parameters.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<String, Object> pair = it.next();
	        
	        String queryParameter;
	        
	        if ((queryParameter = addQueryParameter(pair.getKey(), pair.getValue())) != null) {
				queryParameters.append("&");
	        	queryParameters.append(queryParameter);
	        }
	        
	        it.remove();
	    }
		
		return "/search/browse?" + queryParameters;
	}
	
	@Override
	public @NotNull String getMethod() {
		return "POST";
	}
	
	private String addQueryParameter(String key, Object value) throws UnsupportedEncodingException {
		if (value == null) {
		    return null;
		}
		
		StringBuffer queryParameter = new StringBuffer();
		
		queryParameter.append(key);
		queryParameter.append("=");
		queryParameter.append(encodeParameter(value.toString()));
		
		return queryParameter.toString();
	}
	
	private String encodeParameter(String parameter) throws UnsupportedEncodingException {
        return URLEncoder.encode(parameter, "UTF-8");
    }

	@Override
	public ECPResponseParser<Void> getParser() {
		return null;
	}
}
