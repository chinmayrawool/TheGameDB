package com.mad.thegamedb;

import android.os.AsyncTask;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Chinmay Rawool on 2/18/2017.
 */

public class GetDataAsync extends AsyncTask<String,Void,ArrayList<Game>> {

    GameData activity;
    public GetDataAsync(GameData activity){
        this.activity=activity;
    }
    @Override
    protected void onPostExecute(ArrayList<Game> games) {
        super.onPostExecute(games);
        activity.setDataToActivity(games);

    }
    static public interface GameData {
        public void setDataToActivity(ArrayList<Game> games);

    }

    @Override
    protected ArrayList<Game> doInBackground(String... strings) {
        URL url=null;
        try {
            url=new URL(strings[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            if(con.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream in = con.getInputStream();
                return GameUtil.GamesSAXParser.parseGame(in);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return null;
    }
}
