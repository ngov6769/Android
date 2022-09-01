package com.example.collapsetoolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private FloatingActionButton button;
    UserAdapter adapter;
    Menu tmenu;
    boolean isExpended = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        setToolBar();
        setRecyclerView();
        setToolBarAnimation();
        onClickAdd();
    }
    private void anhXa(){
        appBarLayout = findViewById(R.id.appbarlayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingtoolbarlayout);
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerview);
        button = findViewById(R.id.floating);
    }
    private void setToolBar(){
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setRecyclerView(){
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new UserAdapter();
        adapter.setData(getListUser());
        recyclerView.setAdapter(adapter);
    }
    private List<User> getListUser(){
        List<User> list=new ArrayList<>();
        list.add(new User(R.drawable.user_30,"Nguyễn Đình Lợi","Đà Nẵng"));
        list.add(new User(R.drawable.user_30,"Phan Viết Trọng Cảnh","Quảng Nam"));
        list.add(new User(R.drawable.user_30,"Nguyễn Đình Hóa","Đà Nẵng"));
        return list;
    }
    private void setToolBarAnimation(){
        collapsingToolbarLayout.setTitle("Danh sách sinh viên");
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.phong_canh);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                int color = palette.getVibrantColor(getResources().getColor(R.color.purple_500));
                collapsingToolbarLayout.setContentScrimColor(color);
                collapsingToolbarLayout.setStatusBarScrimColor(getResources().getColor(R.color.black));
            }
        });
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(Math.abs(verticalOffset) > 200) isExpended = false;
                else isExpended = true;
                invalidateOptionsMenu();
            }
        });
    }
    private void onClickAdd(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Add thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        tmenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(tmenu!=null&&(!isExpended||tmenu.size()!=1))
            tmenu.add("Add").setIcon(R.drawable.ic_round_add_24).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.seting)
            Toast.makeText(MainActivity.this, "Ban chon Setting", Toast.LENGTH_SHORT).show();
        if(item.getItemId() == android.R.id.home)
            Toast.makeText(MainActivity.this, "Ban chon Home", Toast.LENGTH_SHORT).show();
        if(item.getTitle() == "Add"){
            Toast.makeText(MainActivity.this, "Ban chon Add", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}