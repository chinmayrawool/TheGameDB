package com.mad.thegamedb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by neha5 on 18-02-2017.
 */

public class GetImage extends AsyncTask<String,Void,Bitmap>{
    IGetImage activity;

    public GetImage(IGetImage activity) {
        this.activity = activity;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            Bitmap img = BitmapFactory.decodeStream(con.getInputStream());
            return img;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        activity.sendImage(bitmap);
    }

    public static interface IGetImage{
        public void sendImage(Bitmap img);
    }
}
