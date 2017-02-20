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
import android.widget.Toast;

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
        }else{
            Toast.makeText(this, "No Image to display", Toast.LENGTH_SHORT).show();
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

        findViewById(R.id.btn_play_trailer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!game.getYouTubeUrl().equals("")) {
                    Intent in = new Intent(GameDetails.this,WebViewActivity.class);
                    in.putExtra("YoutubeURL",game.getYouTubeUrl());
                    startActivity(in);
                }else{
                    Toast.makeText(GameDetails.this, "No Youtube link", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.btn_similar_game).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call new activity
                Intent i = new Intent(GameDetails.this,SimilarGames.class);
                ArrayList<String> similarGames = game.getSimilarGames();
                i.putExtra(SIMILAR_GAMES,similarGames);
                i.putExtra(GAME_KEY,game.getTitle());
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

