package com.example.quytrnhthitk;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;

import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    RelativeLayout manhinh;
    Button btchon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manhinh = findViewById(R.id.manhinh);
        btchon = findViewById(R.id.buttonchon);
        if(getSupportActionBar()!=null)
        getSupportActionBar().setTitle("Menu Context");
        registerForContextMenu(btchon);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context,menu);
        menu.setHeaderTitle("Chọn màu");
        menu.setHeaderIcon(R.mipmap.ic_launcher);

    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.doo){
            Toast.makeText(this, "Bạn chọn đỏ", Toast.LENGTH_SHORT).show();
            manhinh.setBackgroundColor(Color.RED);
        }
        if(item.getItemId()==R.id.xanh){
            Toast.makeText(this, "Bạn chọn xanh", Toast.LENGTH_SHORT).show();
            manhinh.setBackgroundColor(Color.GREEN);
        }
        if(item.getItemId()==R.id.vang){
            Toast.makeText(this, "Bạn chọn vàng", Toast.LENGTH_SHORT).show();
            manhinh.setBackgroundColor(Color.YELLOW);
        }
        return super.onContextItemSelected(item);
    }
}