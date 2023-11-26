package com.wseemann.ecp.parser;

import java.io.IOException;
import java.io.StringReader;

import com.wseemann.ecp.model.Player;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public final class PlayerParser extends ECPResponseParser<Player> {

    @Override
    public Player parse(byte [] body) throws IOException, JDOMException {
        Player player = new Player();

        if (body == null) {
            return player;
        }

        SAXBuilder builder = new SAXBuilder();

        Document document = builder.build(new StringReader(new String(body)));
        Element rootNode = document.getRootElement();

        if (rootNode.getAttribute("state") != null) {
            player.setState(rootNode.getAttribute("state").getValue());
        }

        return player;
    }
}
