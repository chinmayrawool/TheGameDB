package com.mad.thegamedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SimilarGames extends AppCompatActivity implements GetGameDetails.IGameData{

    String baseUrl = "http://thegamesdb.net/api/";
    LinearLayout layout;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_similar_games);
        layout = (LinearLayout) findViewById(R.id.linear_similar_games);
        title = (TextView) findViewById(R.id.tv_similar_games);
        ArrayList<String> games = (ArrayList<String>) getIntent().getExtras().getSerializable(GameDetails.SIMILAR_GAMES);
        String gameTitle = getIntent().getExtras().getString(GameDetails.GAME_KEY);

        title.setText("Similar games to "+gameTitle);
        if(games.size()==0){
            TextView tv = new TextView(this);
            tv.setText("No similar games found");
            layout.addView(tv);
        }else {
            for (int i = 0; i < games.size(); i++) {
                String url = baseUrl + "GetGame.php?id=" + games.get(i);
                new GetGameDetails(this).execute(url);
            }
        }

        findViewById(R.id.btn_similar_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    @Override
    public void sendGameDetails(GameOverview game) {
        if(game!=null) {
            TextView tv = new TextView(this);
            tv.setText(game.display());
            layout.addView(tv);
        }
    }
}
