package com.example.sqlhinhanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static DataSQL dataSQL;
    ListView danhsach;
    HinhAnhAdapter adapter;
    ArrayList<HinhAnh> hinhAnhArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button add = (Button) findViewById(R.id.them);
        danhsach = (ListView) findViewById(R.id.danhsach);
        hinhAnhArrayList = new ArrayList<>();
        adapter = new HinhAnhAdapter(MainActivity.this,R.layout.dong_hinhanh,hinhAnhArrayList);
        danhsach.setAdapter(adapter);

        dataSQL = new DataSQL(MainActivity.this,"QuanLy.sqlite",null,1);
        dataSQL.SetDataSQL("CREATE TABLE IF NOT EXISTS DOVAT(ID INTEGER PRIMARY KEY AUTOINCREMENT,TEN VARCHAR(200), MOTA VARCHAR(300),HINHANH BLOB)");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActivityThem.class);
                startActivity(intent);
            }
        });
        //Toast.makeText(MainActivity.this, "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", Toast.LENGTH_SHORT).show();
        extracted();
    }

    private void extracted() {
        Cursor cursor = dataSQL.getDataSQL("SELECT * FROM DOVAT");
        hinhAnhArrayList.clear();
        while(cursor.moveToNext()){
            hinhAnhArrayList.add(new HinhAnh(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getBlob(3)
            ));
        }
        adapter.notifyDataSetChanged();
    }
}