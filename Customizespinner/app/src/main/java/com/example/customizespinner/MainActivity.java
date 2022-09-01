package com.example.customizespinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    AdapterCategory adapter;
    ArrayList<Category> array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         spinner = findViewById(R.id.spinner);
         array= new ArrayList<>();
         array.add(new Category("Lap trinh android"));
         array.add(new Category("Lap trinh PHP"));
         array.add(new Category("Lap trinh Web"));
         array.add(new Category("Lap trinh Java"));
         adapter = new AdapterCategory(MainActivity.this, R.layout.dong_list,array);
         spinner.setAdapter(adapter);
    }
}