package com.mad.thegamedb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class GameDetails extends AppCompatActivity implements GetImage.IGetImage{
    TextView title,overview,genrePublisher;
    ImageView gameImg;
    LinearLayout mainLayout;
    public static final String SIMILAR_GAMES = "similar games";
    public static final String GAME_KEY = "Game title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        final GameOverview game = (GameOverview) getIntent().getExtras().getSerializable(MainActivity.GAME_KEY);
        mainLayout = (LinearLayout) findViewById(R.id.activity_game_details);
        title = (TextView) findViewById(R.id.tv_gameTitle);
        overview = (TextView) findViewById(R.id.tv_overview);
        genrePublisher = (TextView) findViewById(R.id.tv_genre_publisher);
        gameImg = (ImageView) findViewById(R.id.iv_gameImage);

        String baseUrl = game.getBaseImgUrl();
        String imgUrl = game.getImgUrl();
        if(!(baseUrl.equals("")||imgUrl.equals(""))){
            new GetImage(this).execute(game.getBaseImgUrl()+game.getImgUrl());
        }

        title.setText(game.getTitle());
        overview.setText(game.getOverview());
        genrePublisher.setText("Genre: "+game.getGenres()+"\n"+"Publisher: "+game.getPublisher());

        findViewById(R.id.btn_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /*findViewById(R.id.btn_play_trailer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView webView = new WebView(GameDetails.this);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setMinimumHeight(200);
                webView.setMinimumWidth(200);
                mainLayout.addView(webView);
                if(!game.getYouTubeUrl().equals("")) {
                    webView.setWebViewClient(new WebViewClient());
                    webView.loadUrl(game.getYouTubeUrl());
                }
            }
        });*/

        findViewById(R.id.btn_similar_game).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call new activity
                Intent i = new Intent(GameDetails.this,SimilarGames.class);
                ArrayList<String> similarGames = game.getSimilarGames();
                i.putExtra(SIMILAR_GAMES,similarGames);
                i.putExtra(GAME_KEY,game.getGameTitle());
                startActivity(i);
            }
        });
    }

    @Override
    public void sendImage(Bitmap img) {
        if(img!=null)
            gameImg.setImageBitmap(img);

    }
}

