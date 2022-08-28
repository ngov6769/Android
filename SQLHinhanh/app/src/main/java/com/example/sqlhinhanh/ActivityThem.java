package com.example.sqlhinhanh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ActivityThem extends AppCompatActivity {
    EditText tened,motaed;
    ImageView hinhanh;
    ImageButton cameraib,colectionib;
    Button cancelbtn,xacnhanbtn;
    int CodeCamera = 123,CodeColection = 125;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them);
        Anhxa();
        xacnhanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) hinhanh.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream);
                byte[] hinhAnh = byteArrayOutputStream.toByteArray();
                MainActivity.dataSQL.INSERT_DOVAT(tened.getText().toString().trim(),
                        motaed.getText().toString().trim(),
                        hinhAnh);
                Toast.makeText(ActivityThem.this, "Đã thêm thành công", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ActivityThem.this,MainActivity.class));
            }
        });
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityThem.this,MainActivity.class);
                startActivity(intent);
            }
        });
        cameraib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //startActivityForResult(intent,CodeCamera);
                ActivityCompat.requestPermissions(ActivityThem.this,
                        new String[]{Manifest.permission.CAMERA},
                        CodeCamera);
            }
        });
        colectionib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,CodeColection);*/
                ActivityCompat.requestPermissions(ActivityThem.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        CodeColection);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == CodeCamera){
            if(grantResults.length>0&&grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CodeCamera);
            }
            else Toast.makeText(ActivityThem.this, "Ban ko cho phép mở Camera", Toast.LENGTH_SHORT).show();
        }
        if(requestCode == CodeColection){
            if(grantResults.length>0&&grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,CodeColection);
            }
            else Toast.makeText(ActivityThem.this, "Bạn ko cho phép truy cập vào thư viện", Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            if((requestCode == CodeCamera ) && (resultCode == RESULT_OK) && (data != null)){
                Bitmap anh = (Bitmap) data.getExtras().get("data");
                hinhanh.setImageBitmap(anh);
            }
            if((requestCode == CodeColection ) && (resultCode == RESULT_OK) && (data != null)){
                Uri url = data.getData();
                try {
                    InputStream inputStream = getContentResolver().openInputStream(url);
                    Bitmap anh = BitmapFactory.decodeStream(inputStream);
                    hinhanh.setImageBitmap(anh);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    void Anhxa(){
        tened = (EditText) findViewById(R.id.nhapten);
        motaed = (EditText) findViewById(R.id.mota);
        hinhanh = (ImageView) findViewById(R.id.anh);
        cameraib = (ImageButton) findViewById(R.id.camera);
        colectionib = (ImageButton) findViewById(R.id.colection);
        cancelbtn = (Button) findViewById(R.id.cancel);
        xacnhanbtn = (Button) findViewById(R.id.conform);
    }

}