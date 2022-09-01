package com.example.quytrnhthitk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextView tvclick;
    Button btstart;
    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvclick=(TextView) findViewById(R.id.click);
        btstart=(Button) findViewById(R.id.buttonstart);
        btstart.setVisibility(View.INVISIBLE);
        tvclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog_DangNhap();
            }
        });
        chuyen();
    }
    void Dialog_DangNhap(){
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setCanceledOnTouchOutside(false);
        EditText etten=(EditText) dialog.findViewById(R.id.editname);
        EditText edpass=(EditText) dialog.findViewById(R.id.editpass);
        Button btdongy=(Button) dialog.findViewById(R.id.buttondongy);
        Button bthuy=(Button) dialog.findViewById(R.id.buttonhuy);
        btdongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameuser = etten.getText().toString().trim();
                String password = edpass.getText().toString().trim();
                if(nameuser.equals("Hoa123")&&password.equals("12345")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    btstart.setVisibility(View.VISIBLE);
                    tvclick.setVisibility(View.INVISIBLE);
                    dialog.cancel();
                }
                else {
                    Toast.makeText(MainActivity.this, "Lỗi đang nhập", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bthuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
    void chuyen(){
        btstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity_2.class);
                startActivity(intent);
            }
        });
    }
}