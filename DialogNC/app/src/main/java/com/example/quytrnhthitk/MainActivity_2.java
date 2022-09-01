package com.example.quytrnhthitk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_2 extends Activity {
    Button btnext/*,btback*/;
    RadioButton cau1,cau2,cau3,cau4;
    TextView cauhoi,dapan;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        anh_xa();
        //back();
        cau_1();
        tick();
        dap_an();
        next();
    }
    void anh_xa(){
        btnext=(Button) findViewById(R.id.buttonnext);
        //btback=(Button) findViewById(R.id.buttonback);
        cau1=(RadioButton) findViewById(R.id.text1);
        cau2=(RadioButton) findViewById(R.id.text2);
        cau3=(RadioButton) findViewById(R.id.text3);
        cau4=(RadioButton) findViewById(R.id.text4);
        cauhoi=(TextView) findViewById(R.id.textcauhoi);
        dapan=(TextView) findViewById(R.id.textviewdapan);
        radioGroup=(RadioGroup) findViewById(R.id.radiochun);
    }
    void cau_1(){
        cauhoi.setText("Câu 1: Trong không gian Oxyz, cho A(1;2;0), B(3;-1;1), C(1;1;1). Tính diện tích S của tam giác ABC.");
        cau1.setText("A. S = 1");
        cau2.setText("B. S = 0.5");
        cau3.setText("C. S = Sqrt(3)");
        cau4.setText("D. S = Sqrt(2)");
    }
    void tick() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(R.id.text1==checkedId){
                    Toast.makeText(MainActivity_2.this, "Bạn chọn A", Toast.LENGTH_SHORT).show();
                }
                if(R.id.text2==checkedId){
                    Toast.makeText(MainActivity_2.this, "Bạn chọn B", Toast.LENGTH_SHORT).show();
                }
                if(R.id.text3==checkedId){
                    Toast.makeText(MainActivity_2.this, "Bạn chọn C", Toast.LENGTH_SHORT).show();
                }
                if(R.id.text4==checkedId){
                    Toast.makeText(MainActivity_2.this, "Bạn chọn D", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void dap_an(){
        dapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cau1.isChecked()||cau2.isChecked()||cau3.isChecked()||cau4.isChecked()) {
                    dapan.setText("Đáp án: C");
                }
                else Toast.makeText(MainActivity_2.this, "Vui lòng chọn đáp án", Toast.LENGTH_SHORT).show();
            }
        });
    }
    /*void back(){
        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity_2.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }*/
    void next(){
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity_2.this,MainActivity_22.class);
                startActivity(intent);
            }
        });
    }
}