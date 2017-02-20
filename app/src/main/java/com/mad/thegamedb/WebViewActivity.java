package com.mad.thegamedb;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        //getActionBar().setTitle("Youtube Video");
        String url = getIntent().getExtras().getString("YoutubeURL");
        WebView webView = (WebView) findViewById(R.id.wv1);
        Log.d("demo","Youtube link"+url);
        String url1 = url.replace("watch?v=","embed/");
        Log.d("demo","Youtube link embed"+url1);
        String playVideo= "<iframe width=\"320\" height=\"200\" src=\""+url1+"\" frameborder=\"0\" allowfullscreen></iframe>";
        try {
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    return false;
                }
            });
            webView.getSettings().setJavaScriptEnabled(true);
            //webView.loadUrl(url);
            webView.loadData(playVideo, "text/html", "utf-8");
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        findViewById(R.id.btn_webView_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    @Override
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

}
