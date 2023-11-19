package com.jaku.request;

import com.jaku.core.JakuRequestData;

public class QueryMediaPlayerRequest extends JakuRequestData {

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
}
