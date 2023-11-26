package com.wseemann.ecp.request;

import com.wseemann.ecp.core.ECPRequest;
import com.wseemann.ecp.model.Player;
import com.wseemann.ecp.parser.ECPResponseParser;
import com.wseemann.ecp.parser.PlayerParser;

final public class QueryMediaPlayerRequest extends ECPRequest<Player> {

    public QueryMediaPlayerRequest(String url) {
        super(url);
    }

    @Override
    public String getPath() {
        return "/query/media-player";
    }

    @Override
    public String getMethod() {
        return "GET";
    }

    @Override
    public ECPResponseParser<Player> getParser() {
        return new PlayerParser();
    }
}
