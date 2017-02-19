package com.mad.thegamedb;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by neha5 on 18-02-2017.
 */

public class GameOverview implements Serializable{
    String title, overview, publisher, genres, baseImgUrl, imgUrl,youTubeUrl,releaseDate,platform,id;
    ArrayList<String> similarGames;

    public GameOverview() {
        genres = "";
        baseImgUrl = "";
        youTubeUrl = "";
        imgUrl = "";
        similarGames = new ArrayList<String>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBaseImgUrl() {
        return baseImgUrl;
    }

    public void setBaseImgUrl(String baseImgUrl) {
        this.baseImgUrl = baseImgUrl;
    }

    public String getYouTubeUrl() {
        return youTubeUrl;
    }

    public void setYouTubeUrl(String youTubeUrl) {
        this.youTubeUrl = youTubeUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public ArrayList<String> getSimilarGames() {
        return similarGames;
    }

    public void setSimilarGames(ArrayList<String> similarGames) {
        this.similarGames = similarGames;
    }

    @Override
    public String toString() {
        return "GameOverview{" +
                "title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", publisher='" + publisher + '\'' +
                ", genres='" + genres + '\'' +
                ", baseImgUrl='" + baseImgUrl + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", youTubeUrl='" + youTubeUrl + '\'' +
                ", similarGames=" + similarGames +
                '}';
    }

    public String display(){
         /*Date date = new Date(getReleaseDate());
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
         String str = dateFormat.format(date);*/
        return getTitle()+". Released in "+getReleaseDate()+". Platform: "+getPlatform();
    }
}
