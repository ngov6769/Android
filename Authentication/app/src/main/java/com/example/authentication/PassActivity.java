package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
//ngoloi2k2@gmail.com
public class PassActivity extends AppCompatActivity {
    Button conformpass,back;
    TextView emailtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);
        anhXa();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PassActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        conformpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth auth = FirebaseAuth.getInstance();
                if(emailtxt.getText().toString().length()<=0){
                    Toast.makeText(PassActivity.this, "Vui lòng nhập thông tin gmail!", Toast.LENGTH_SHORT).show();
                }
                else{
                    auth.sendPasswordResetEmail(emailtxt.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(PassActivity.this, "Vui lòng kiểm tra tin nhắn trong gmail!", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(PassActivity.this, task.getException().getMessage()+"", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
    private void anhXa(){
        conformpass = findViewById(R.id.xacnhanpass);
        emailtxt = findViewById(R.id.email);
        back = findViewById(R.id.back);
    }
}