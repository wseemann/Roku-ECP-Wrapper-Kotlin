package com.jaku.request;

import com.jaku.core.JakuRequestData;
import com.jaku.parser.JakuParser;
import com.jaku.parser.PlayerParser;

final public class QueryMediaPlayerRequest extends JakuRequestData {

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
    public JakuParser<?> getParser() {
        return new PlayerParser();
    }
}
