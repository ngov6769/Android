package com.example.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ActivityAdd extends AppCompatActivity {
    EditText hotened,namsinhed,diachied;
    Button xacnhanbtn,huybtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        AnhXa();
        huybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAdd.this,MainActivity.class);
                startActivity(intent);
            }
        });
        xacnhanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten,namsinh,diachi;
                hoten = hotened.getText().toString().trim();
                namsinh = namsinhed.getText().toString().trim();
                diachi = diachied.getText().toString().trim();
                if(hoten.isEmpty()||namsinh.isEmpty()||diachi.isEmpty()){
                    Toast.makeText(ActivityAdd.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else{
                    ReadString("http://192.168.1.7:81/sever/Insert.php");
                }
            }
        });
    }
    private void ReadString(String url){
        RequestQueue queue  = Volley.newRequestQueue(ActivityAdd.this);
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("Success!")){
                            Toast.makeText(ActivityAdd.this, "Đã thêm thành công!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ActivityAdd.this,MainActivity.class));
                        }
                    }
                }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(ActivityAdd.this, "Lỗi thêm vào!", Toast.LENGTH_SHORT).show();
                }
            }
            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String > params = new HashMap<>();
                    params.put("hotenSV",hotened.getText().toString().trim());
                    params.put("namsinhSV",namsinhed.getText().toString().trim());
                    params.put("diachiSV",diachied.getText().toString().trim());
                    return params;
                }
            };
        queue.add(request);
    }
    private void AnhXa(){
        hotened = (EditText) findViewById(R.id.hotenadd);
        namsinhed = (EditText) findViewById(R.id.namsinhadd);
        diachied = (EditText) findViewById(R.id.diachiadd);
        xacnhanbtn = (Button) findViewById(R.id.xacnhanaddbtn);
        huybtn = (Button) findViewById(R.id.huyaddbtn);
    }
}