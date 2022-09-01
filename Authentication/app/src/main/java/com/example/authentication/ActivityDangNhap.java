package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityDangNhap extends AppCompatActivity {
    Button xacnhanbtn,huybtn;
    EditText nhapedt,passedt;
    TextView quenpasstxt;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        anhXa();
        auth = FirebaseAuth.getInstance();
        huybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDangNhap.this,MainActivity.class);
                startActivity(intent);
            }
        });
        xacnhanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xacNhan();
            }
        });
        quenpasstxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDangNhap.this,PassActivity.class);
                startActivity(intent);
            }
        });
    }
    private void anhXa(){
        xacnhanbtn = findViewById(R.id.xacnhan);
        huybtn = findViewById(R.id.huy);
        nhapedt = findViewById(R.id.emailaddress);
        passedt = findViewById(R.id.password);
        quenpasstxt = findViewById(R.id.quenpass);
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = auth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
        nhapedt.setText(currentUser.getEmail());
    }
    private void xacNhan(){
        if(nhapedt.length()<=0 || passedt.length()<=0){
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
        }
        else{
            auth.signInWithEmailAndPassword(nhapedt.getText().toString(),passedt.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Intent intent = new Intent(ActivityDangNhap.this,MainActivity2.class);
                        startActivity(intent);
                    }
                    else Toast.makeText(ActivityDangNhap.this, "Lỗi đăng nhập!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}