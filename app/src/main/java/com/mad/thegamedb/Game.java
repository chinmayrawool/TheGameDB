package com.mad.thegamedb;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Chinmay Rawool on 2/18/2017.
 */

public class Game {
    String gameTitle,releaseDate,platform,id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameTitle='" + gameTitle + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", platform='" + platform + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
     public String display(){
         /*Date date = new Date(getReleaseDate());
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
         String str = dateFormat.format(date);*/
         return getGameTitle()+". Released in "+getReleaseDate()+". Platform: "+getPlatform();
     }
}
