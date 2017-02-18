package com.mad.thegamedb;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GetDataAsync.GameData{
    LinearLayout linearLayout;
    EditText et;
    String url="";
    ArrayList<Game> gameList;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(isConnectedOnline()){
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        linearLayout = (LinearLayout) findViewById(R.id.linear1);
        final String baseUrl = "http://thegamesdb.net/api/";
        et = (EditText)findViewById(R.id.db_et_search);

        findViewById(R.id.db_btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et = (EditText)findViewById(R.id.db_et_search);
                String text = et.getText().toString();
                if(!(text.equals(""))){
                    String extraUrl = "GetGamesList.php?name="+text;
                    url = baseUrl + extraUrl;
                    progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setMessage("Computing Progress");
                    progressDialog.setCancelable(false);
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.show();

                    new GetDataAsync(MainActivity.this).execute(url);
                }
            }
        });

    }
    private boolean isConnectedOnline(){
        ConnectivityManager cm = ((ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if(networkInfo !=null && networkInfo.isConnected()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void setDataToActivity(ArrayList<Game> games) {
        gameList = games;
        progressDialog.dismiss();
        Log.d("demo",gameList.toString().trim());
    }
}
