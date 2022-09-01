package com.example.quytrnhthitk;

import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    ImageView ivanh;
    Button btclip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivanh = findViewById(R.id.imageViewanh);
        btclip = findViewById(R.id.buttonanh);
        ivanh.setImageLevel(0);
        ClipDrawable clipDrawable = (ClipDrawable) ivanh.getDrawable();
        btclip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int x = clipDrawable.getLevel();
                        if (x >= 10000) x = 0;
                        ivanh.setImageLevel( x + 1000);
                        handler.postDelayed(this,100);
                    }
                },100);

            }
        });
    }
}