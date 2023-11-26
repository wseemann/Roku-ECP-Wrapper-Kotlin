package com.jaku.request;

import com.jaku.core.JakuRequest;
import com.jaku.model.Player;
import com.jaku.parser.JakuParser;
import com.jaku.parser.PlayerParser;

final public class QueryMediaPlayerRequest extends JakuRequest<Player> {

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
    public JakuParser<Player> getParser() {
        return new PlayerParser();
    }
}
