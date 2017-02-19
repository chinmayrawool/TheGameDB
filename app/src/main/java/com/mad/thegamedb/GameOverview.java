package com.mad.thegamedb;

import java.io.Serializable;

/**
 * Created by neha5 on 18-02-2017.
 */

public class GameOverview implements Serializable{
    String title, overview, publisher, genres, baseImgUrl, youTubeUrl, imgUrl;


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

    @Override
    public String toString() {
        return "GameOverview{" +
                "title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", publisher='" + publisher + '\'' +
                ", genres='" + genres + '\'' +
                ", baseImgUrl='" + baseImgUrl + '\'' +
                ", youTubeUrl='" + youTubeUrl + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
