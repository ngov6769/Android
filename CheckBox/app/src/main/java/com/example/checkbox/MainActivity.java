package com.example.checkbox;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CheckBox ios,android,web;
    Button conform;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        conform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mon="Ban da chon mon: \n";
                if(ios.isChecked()){
                    mon=mon+ios.getText().toString()+"\n";
                }
                if(android.isChecked()){
                    mon=mon+android.getText().toString()+"\n";
                }
                if(web.isChecked()){
                    mon=mon+web.getText().toString()+"\n";
                }
                Toast.makeText(MainActivity.this, mon, Toast.LENGTH_SHORT).show();
            }
        });
        Kt_check();
    }
    void AnhXa(){
        ios = (CheckBox) findViewById(R.id.ios);
        android = (CheckBox) findViewById(R.id.android);
        web = (CheckBox) findViewById(R.id.web);
        conform = (Button) findViewById(R.id.xatnhan);
    }
    void Kt_check(){
        ios.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Ban da chon "+ios.getText(), Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(MainActivity.this, "Ban da huy chon "+ios.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        android.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Ban da chon "+android.getText(), Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(MainActivity.this, "Ban da huy chon "+android.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        web.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Ban da chon "+web.getText(), Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(MainActivity.this, "Ban da huy chon "+web.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}