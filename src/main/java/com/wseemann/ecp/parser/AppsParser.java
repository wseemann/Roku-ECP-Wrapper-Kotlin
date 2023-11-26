package com.wseemann.ecp.parser;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import com.wseemann.ecp.model.Channel;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public final class AppsParser extends ECPResponseParser<List<Channel>> {

	@Override
	public List<Channel> parse(byte [] body) throws IOException, JDOMException {
		List<Channel> channels = new ArrayList<>();

		if (body == null) {
			return channels;
		}

        SAXBuilder builder = new SAXBuilder();

        Document document;
        document = builder.build(new StringReader(new String(body)));
        Element rootNode = document.getRootElement();

        List<Element> children = rootNode.getChildren();

        for (int i = 0; i < children.size(); i++) {
            Element element = children.get(i);

            if (element.getAttribute("id") == null) {
                continue;
            }

            Channel channel = new Channel();
            channel.setId(element.getAttribute("id").getValue());
            channel.setTitle(element.getValue());
            channel.setType(element.getAttribute("type").getValue());
            channel.setVersion(element.getAttribute("version").getValue());

            channels.add(channel);
        }

        return channels;
	}
}
