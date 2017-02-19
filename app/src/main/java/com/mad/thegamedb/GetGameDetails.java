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
 * Created by neha5 on 18-02-2017.
 */

public class GetGameDetails extends AsyncTask<String, Void, GameOverview> {

    IGameData activity;

    public GetGameDetails(IGameData activity) {
        this.activity = activity;
    }

    @Override
    protected void onPostExecute(GameOverview gameDetails) {
        super.onPostExecute(gameDetails);
        activity.sendGameDetails(gameDetails);

    }
    static public interface IGameData {
        public void sendGameDetails(GameOverview game);

    }

    @Override
    protected GameOverview doInBackground(String... strings) {
        URL url=null;
        try {
            url=new URL(strings[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            if(con.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream in = con.getInputStream();
                return GameOverviewUtil.GameDetailsSAXParser.parseGame(in);
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
