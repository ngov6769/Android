package com.example.quytrnhthitk;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {
    TextView tvin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvin=(TextView) findViewById(R.id.textView);
        Calendar calendar=Calendar.getInstance();
        tvin.setText(calendar.getTime()+"\n");
        tvin.append(calendar.get(Calendar.DATE)+"\n");
        SimpleDateFormat siformat=new SimpleDateFormat("dd/MM/yyyy");
        tvin.append(siformat.format(calendar.getTime()));
    }
}