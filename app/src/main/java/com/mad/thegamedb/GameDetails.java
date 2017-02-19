package com.mad.thegamedb;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GameDetails extends AppCompatActivity implements GetImage.IGetImage{
    TextView title,overview,genrePublisher;
    ImageView gameImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        GameOverview game = (GameOverview) getIntent().getExtras().getSerializable(MainActivity.GAME_KEY);
        title = (TextView) findViewById(R.id.tv_gameTitle);
        overview = (TextView) findViewById(R.id.tv_overview);
        genrePublisher = (TextView) findViewById(R.id.tv_genre_publisher);
        gameImg = (ImageView) findViewById(R.id.iv_gameImage);

        new GetImage(this).execute(game.getBaseImgUrl()+game.getImgUrl());
        title.setText(game.getTitle());
        overview.setText(game.getOverview());
        genrePublisher.setText("Genre: "+game.getGenres()+"\n"+"Publisher: "+game.getPublisher());



    }

    @Override
    public void sendImage(Bitmap img) {
        gameImg.setImageBitmap(img);
    }
}
