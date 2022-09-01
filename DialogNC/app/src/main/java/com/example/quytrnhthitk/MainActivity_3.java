package com.example.quytrnhthitk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_3 extends Activity {
    Button btnext,btback;
    RadioButton cau1,cau2,cau3,cau4;
    TextView cauhoi,dapan;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);
        anh_xa();
        back();
        cau_2();
        tick();
        dap_an();
    }
    void anh_xa(){
        btnext=(Button) findViewById(R.id.buttonnext);
        btback=(Button) findViewById(R.id.buttonback);
        cau1=(RadioButton) findViewById(R.id.text1);
        cau2=(RadioButton) findViewById(R.id.text2);
        cau3=(RadioButton) findViewById(R.id.text3);
        cau4=(RadioButton) findViewById(R.id.text4);
        cauhoi=(TextView) findViewById(R.id.textcauhoi);
        dapan=(TextView) findViewById(R.id.textviewdapan);
        radioGroup=(RadioGroup) findViewById(R.id.radiochun);
    }
    void cau_2(){
        cauhoi.setText("Câu 2: Trong không gian Oxyz, cho mp(A) x+2y-3=0. Một vectơ pháp tuyến của (A) có tọa độ là: ");
        cau1.setText("A. (1;0;2)");
        cau2.setText("B. (1;-2;3)");
        cau3.setText("C. (1;2;0)");
        cau4.setText("D. (1;2;-3)");
    }
    void tick() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(R.id.text1==checkedId){
                    Toast.makeText(MainActivity_3.this, "Bạn chọn A", Toast.LENGTH_SHORT).show();
                }
                if(R.id.text2==checkedId){
                    Toast.makeText(MainActivity_3.this, "Bạn chọn B", Toast.LENGTH_SHORT).show();
                }
                if(R.id.text3==checkedId){
                    Toast.makeText(MainActivity_3.this, "Bạn chọn C", Toast.LENGTH_SHORT).show();
                }
                if(R.id.text4==checkedId){
                    Toast.makeText(MainActivity_3.this, "Bạn chọn D", Toast.LENGTH_SHORT).show();
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
                else Toast.makeText(MainActivity_3.this, "Vui lòng chọn đáp án", Toast.LENGTH_SHORT).show();
            }
        });
    }
    void back(){
        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity_3.this,MainActivity_2.class);
                startActivity(intent);
            }
        });
    }
    /*void next(){
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity_3.this,MainActivity_4.class);
                startActivity(intent);
            }
        });
    }*/
}