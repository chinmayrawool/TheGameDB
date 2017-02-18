package com.mad.thegamedb;

import android.util.Xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Chinmay Rawool on 2/18/2017.
 */

public class GameUtil {

    public static class GamesSAXParser extends DefaultHandler {
        ArrayList<Game> gameList;
        Game game;
        StringBuilder sb;
        public static ArrayList<Game> parseGame(InputStream in) throws IOException, SAXException {
            GamesSAXParser parser = new GamesSAXParser();
            Xml.parse(in, Xml.Encoding.UTF_8,parser);
            return parser.getGameList();
        }

        public ArrayList<Game> getGameList() {
            return gameList;
        }

        public GamesSAXParser() {
            super();
        }

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            gameList = new ArrayList<Game>();
            sb = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            if(localName.equals("Game")){
                game = new Game();
            }

        }
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
            if(localName.equals("Game")){
                gameList.add(game);
            }else if(localName.equals("id")){
                game.setId(sb.toString().trim());
            }else if(localName.equals("GameTitle")){
                game.setGameTitle(sb.toString().trim());
            }else if(localName.equals("ReleaseDate")){
                String str =sb.toString().trim();
                if(!(str.equals(""))) {
                    game.setReleaseDate(sb.toString().trim());
                }
            }else if(localName.equals("Platform")){
                game.setPlatform(sb.toString().trim());
            }
            sb.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);
            sb.append(ch,start,length);
        }
    }

}
