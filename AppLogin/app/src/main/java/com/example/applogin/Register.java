package com.example.applogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://loginoop-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText fullname = findViewById(R.id.name);
        final EditText email = findViewById(R.id.email);
        final EditText phone = findViewById(R.id.phone);
        final EditText pass = findViewById(R.id.password);
        final EditText conpass = findViewById(R.id.conpassemail);

        final Button register = findViewById(R.id.registerbtn);
        final TextView login = findViewById(R.id.loginnow);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fullnametxt = fullname.getText().toString();
                final String emailtxt = email.getText().toString();
                final String phonetxt = phone.getText().toString();
                final String passtxt = pass.getText().toString();
                final String conpasstxt = conpass.getText().toString();

                if(fullnametxt.isEmpty()||emailtxt.isEmpty()||phonetxt.isEmpty()||passtxt.isEmpty()){
                    Toast.makeText(Register.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                }
                else if(passtxt.compareTo(conpasstxt)!=0){
                    Toast.makeText(Register.this, "Passwords are not matching!", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(phonetxt)){
                                Toast.makeText(Register.this, "Phone is already registered", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                databaseReference.child("users").child(phonetxt).child("fullname").setValue(fullnametxt);
                                databaseReference.child("users").child(phonetxt).child("email").setValue(emailtxt);
                                databaseReference.child("users").child(phonetxt).child("pass").setValue(passtxt);
                                Toast.makeText(Register.this, "You are registered successfull.", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}