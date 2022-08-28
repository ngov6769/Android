package com.example.appreadingrss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity_2 extends AppCompatActivity {
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String link = intent.getStringExtra("linkweb");
        //Toast.makeText(MainActivity_2.this, link, Toast.LENGTH_SHORT).show();
        webview = (WebView) findViewById(R.id.webview);
        webview.loadUrl(link);
        webview.setWebViewClient(new WebViewClient());
    }
}