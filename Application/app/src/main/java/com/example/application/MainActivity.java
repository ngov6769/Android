package com.example.application;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView pheptinh,ketqua;
    String pt;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button btnce,btnc,btnde,btncong,btnamduong,btntru,btnnhan,btnchia,btnphay,btnbang;double so1,so2;
    int length_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anh_xa();
        pheptinh.setText("0");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pheptinh.getText().toString() == "0"){
                    pheptinh.setText(btn1.getText().toString());
                }
                else pheptinh.setText(pheptinh.getText().toString()+btn1.getText().toString());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pheptinh.getText().toString() == "0"){
                    pheptinh.setText(btn2.getText().toString());
                }
                else pheptinh.setText(pheptinh.getText().toString()+btn2.getText().toString());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pheptinh.getText().toString() == "0"){
                    pheptinh.setText(btn3.getText().toString());
                }
                else pheptinh.setText(pheptinh.getText().toString()+btn3.getText().toString());
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pheptinh.getText().toString() == "0"){
                    pheptinh.setText(btn4.getText().toString());
                }
                else pheptinh.setText(pheptinh.getText().toString()+btn4.getText().toString());
            }
        });
        //Nhấn số 5 để nhập vào màn hình
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pheptinh.getText().toString() == "0"){
                    pheptinh.setText(btn5.getText().toString());
                }
                else pheptinh.setText(pheptinh.getText().toString()+btn5.getText().toString());
            }
        });
        //Nhấn số 6 để nhập vào màn hình
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pheptinh.getText().toString() == "0"){
                    pheptinh.setText(btn6.getText().toString());
                    Toast.makeText(MainActivity.this, "dung", Toast.LENGTH_SHORT).show();
                }
                else pheptinh.setText(pheptinh.getText().toString()+btn6.getText().toString());
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pheptinh.getText().toString() == "0"){
                    pheptinh.setText(btn7.getText().toString());
                }
                else pheptinh.setText(pheptinh.getText().toString()+btn7.getText().toString());
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pheptinh.getText().toString() == "0"){
                    pheptinh.setText(btn8.getText().toString());
                }
                else pheptinh.setText(pheptinh.getText().toString()+btn8.getText().toString());
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pheptinh.getText().toString() == "0"){
                    pheptinh.setText(btn9.getText().toString());
                }
                else pheptinh.setText(pheptinh.getText().toString()+btn9.getText().toString());
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pheptinh.setText(pheptinh.getText().toString()+btn0.getText().toString());
            }
        });

        btnphay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pheptinh.setText(pheptinh.getText().toString()+".");
            }
        });

        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ketqua.getText().length()>0){
                    //so1 là giá trị thứ nhất vừa nhập
                    so1 = Double.parseDouble(ketqua.getText().toString() + "");
                    pheptinh.setText(ketqua.getText().toString() + btntru.getText().toString());
                    length_2 = ketqua.getText().length()+1;//lấy vị trí bất đầu của số thứ hai
                    ketqua.setText("");
                }
                else {
                    so1 = Double.parseDouble(pheptinh.getText().toString() + "");
                    pheptinh.setText(pheptinh.getText().toString() + btntru.getText().toString());
                    length_2 = pheptinh.getText().length();
                }
                pt = "-";

            }
        });

        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ketqua.getText().length()>0){
                    so1 = Double.parseDouble(ketqua.getText().toString() + "");
                    pheptinh.setText(ketqua.getText().toString() + btnnhan.getText().toString());
                    length_2 = ketqua.getText().length()+1;
                    ketqua.setText("");
                }
                else {
                    so1 = Integer.parseInt(pheptinh.getText().toString() + "");
                    pheptinh.setText(pheptinh.getText().toString() + btnnhan.getText().toString());
                    length_2 = pheptinh.getText().length();
                }
                pt = "x";
            }
        });

        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ketqua.getText().length()>0){
                    so1 = Double.parseDouble(ketqua.getText().toString() + "");
                    pheptinh.setText(ketqua.getText().toString() + btncong.getText().toString());
                    length_2 = ketqua.getText().length()+1;
                    ketqua.setText("");
                }
                else {
                    so1 = Double.parseDouble(pheptinh.getText().toString() + "");
                    pheptinh.setText(pheptinh.getText().toString() + btncong.getText().toString());
                    length_2 = pheptinh.getText().length();
                }
                pt = "+";
            }
        });

        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ketqua.getText().length()>0){
                    so1 = Double.parseDouble(ketqua.getText().toString() + "");
                    pheptinh.setText(ketqua.getText().toString() + btnchia.getText().toString());
                    length_2 = ketqua.getText().length()+1;
                    ketqua.setText("");
                }
                else {
                    so1 = Integer.parseInt(pheptinh.getText().toString());
                    pheptinh.setText(pheptinh.getText().toString() + btnchia.getText().toString());
                    length_2 = pheptinh.getText().length();
                }
                pt = "/";
            }
        });

        btnbang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = "1+1";
                String manhinhc = pheptinh.getText().toString();
                if(manhinhc.equals(a)) ketqua.setText("Quay lại lớp 1 học đi!");
                else {
                    so2 = Double.parseDouble(manhinhc.substring(length_2, manhinhc.length()) + "");
                    if (pt == "+") ketqua.setText((so1 + so2) + "");
                    if (pt == "-") ketqua.setText((so1 - so2) + "");
                    if (pt == "x") ketqua.setText((so1 * so2) + "");
                    if (pt == "/") ketqua.setText((so1 / so2) + "");
                }
            }
        });

        btnamduong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pheptinh.getText().toString() == "0"){
                    pheptinh.setText("-");
                }
                else pheptinh.setText(pheptinh.getText().toString()+"-");
            }
        });

        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoi = pheptinh.getText().toString();
                chuoi = chuoi.substring(0,chuoi.length()-1);
                pheptinh.setText(chuoi);
            }
        });

        btnde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pheptinh.setText("0");
            }
        });

        btnce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pheptinh.setText("0");
            }
        });
    }

    private void Anh_xa(){
        btn0 = (Button) findViewById(R.id.btn0);
        btn1= (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnce = (Button) findViewById(R.id.ce);
        btnc = (Button) findViewById(R.id.c);
        btnde = (Button) findViewById(R.id.de);
        btncong = (Button) findViewById(R.id.cong);
        btnamduong = (Button) findViewById(R.id.amduong);
        btntru = (Button) findViewById(R.id.btntru);
        btnnhan = (Button) findViewById(R.id.nhan);
        btnchia = (Button) findViewById(R.id.chia);
        btnphay = (Button) findViewById(R.id.phay);
        btnbang = (Button) findViewById(R.id.bang);
        pheptinh = (TextView) findViewById(R.id.manhinh);
        ketqua = (TextView) findViewById(R.id.ketqua);
    }
}