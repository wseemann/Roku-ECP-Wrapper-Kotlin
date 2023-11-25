package com.jaku.parser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.jaku.core.Response;
import com.jaku.model.Channel;

public final class AppsParser extends JakuParser<List<Channel>> {

	@Override
	public List<Channel> parse(Response response) {
		List<Channel> channels = new ArrayList<Channel>();

		if (response == null || response.getData() == null) {
			return channels;
		}
		
        SAXBuilder builder = new SAXBuilder();

        Document document;
        try {
            document = builder.build(new StringReader(new String(((ByteArrayOutputStream) response.getData()).toByteArray())));
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
        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return channels;
	}
}
