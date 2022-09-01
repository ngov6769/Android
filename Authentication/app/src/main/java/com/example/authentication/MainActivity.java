package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import org.w3c.dom.Text;

public class MainActivity extends Activity {
    EditText passedt,emailedt;
    Button xacnhanedt;
    TextView dangnhaptxt;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        mAuth = FirebaseAuth.getInstance();
        xacnhanedt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dangKi();
            }
        });
        dangnhaptxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dangNhap();
            }
        });
    }
    private void anhXa(){
        passedt = findViewById(R.id.password);
        emailedt = findViewById(R.id.emailaddress);
        xacnhanedt = findViewById(R.id.xacnhan);
        dangnhaptxt = findViewById(R.id.dangnhap);
    }
    private void dangKi(){
        String email = emailedt.getText().toString();
        String password = passedt.getText().toString();
        if(email.length()<=0 || password.length()<=0){
            Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
        }
        else{
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Đăng kí thành công!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "Lỗi đăng kí.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
    private void dangNhap(){
        Intent intent = new Intent(MainActivity.this,ActivityDangNhap.class);
        startActivity(intent);
    }
}