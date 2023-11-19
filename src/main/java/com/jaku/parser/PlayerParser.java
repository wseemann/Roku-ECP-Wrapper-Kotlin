package com.jaku.parser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

import com.jaku.model.Player;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.jaku.core.Response;

public class PlayerParser extends JakuParser {

    @Override
    public Object parse(Response response) {
        Player player = new Player();

        if (response == null || response.getData() == null) {
            return player;
        }

        SAXBuilder builder = new SAXBuilder();

        Document document;
        try {
            document = (Document) builder.build(new StringReader(new String(((ByteArrayOutputStream) response.getData()).toByteArray())));
            Element rootNode = document.getRootElement();

            if (rootNode.getAttribute("state") != null) {
                player.setState(rootNode.getAttribute("state").getValue());
            }
        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return player;
    }
}
