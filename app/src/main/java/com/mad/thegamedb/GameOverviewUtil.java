package com.mad.thegamedb;

import android.util.Xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;


/**
 * Created by neha5 on 18-02-2017.
 */

public class GameOverviewUtil {

    public static class GameDetailsSAXParser extends DefaultHandler {
        GameOverview game;// = new GameOverview();
        StringBuilder sb;
        boolean flag = false, flagImages = false;
        public static GameOverview parseGame(InputStream in) throws IOException, SAXException {
            GameOverviewUtil.GameDetailsSAXParser parser = new GameOverviewUtil.GameDetailsSAXParser();
            Xml.parse(in, Xml.Encoding.UTF_8,parser);
            return parser.getGame();
        }

        public GameOverview getGame() {
            return game;
        }



        @Override
        public void startDocument() throws SAXException {
            super.startDocument();

            sb = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            if(localName.equals("Data") && !flag){
                game = new GameOverview();
                flag = true;
            }else if(localName.equals("Images")){
                flagImages = true;
            }


        }
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);

            if(localName.equals("GameTitle") && flag){
                game.setTitle(sb.toString());
            }else if(localName.equals("Overview") && flag){
                game.setOverview(sb.toString());
            }else if(localName.equals("genre") && flag){
                String genre = sb.toString();
                if(game!=null) {
                    if (game.getGenres().equals("")) {
                        game.setGenres(genre);

                    } else {
                        String str = game.getGenres();
                        str.concat(", " + genre);
                        game.setGenres(str);
                    }
                }
            }else if(localName.equals("Publisher") && flag){
                game.setPublisher(sb.toString());
            }else if(localName.equals("baseImgUrl")){
                game.setBaseImgUrl(sb.toString());
            } else if(localName.equals("original") && flagImages){
                game.setImgUrl(sb.toString());
                flagImages = false;
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
