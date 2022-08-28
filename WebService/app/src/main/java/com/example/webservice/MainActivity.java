package com.example.webservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<SinhVien> arrayList;
    SinhVienAdapter adapter;
    String urldelete = "http://192.168.1.7:81/sever/Delete.php";
    String urlupdate = "http://192.168.1.7:81/sever/Update.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.danhsach);
        arrayList = new ArrayList<>();
        adapter = new SinhVienAdapter(MainActivity.this,R.layout.dong_sinh_vien,arrayList);
        listView.setAdapter(adapter);
        ReadJson("http://192.168.1.7:81/sever/getData.php");
    }
    void ReadJson(String url) {
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        JsonArrayRequest array = new JsonArrayRequest(Request.Method.GET,url,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(MainActivity.this, response.toString()+"", Toast.LENGTH_SHORT).show();
                        for(int i=0;i<response.length();i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                int id = object.getInt("Id");
                                String hoten = object.getString("HoTen");
                                int namsinh = object.getInt("NamSinh");
                                String diachi = object.getString("DiaChi");
                                arrayList.add(new SinhVien(id,hoten,namsinh,diachi));
                                adapter.notifyDataSetChanged();
                                //Toast.makeText(MainActivity.this, id+"\n"+hoten+"\n"+namsinh+"\n"+diachi+"", Toast.LENGTH_SHORT).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(array);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.add){
            Intent intent = new Intent(MainActivity.this,ActivityAdd.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    public void ReadDelete(int id){
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new StringRequest(Request.Method.POST, urldelete,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("Delete success!")) {
                            arrayList.clear();
                            Toast.makeText(MainActivity.this, "Xóa thành công!", Toast.LENGTH_SHORT).show();
                            ReadJson("http://192.168.1.7:81/sever/getData.php");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Xóa không thành công!", Toast.LENGTH_SHORT).show();
                    }
                }
            ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("idSV",Integer.toString(id) );
                return params;
            }
        };
        queue.add(request);
    }
    public void ReadUpdate(String ten,int namsinh,String diachi,int id){
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new StringRequest(Request.Method.POST, urlupdate,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("Success")) {
                            arrayList.clear();
                            Toast.makeText(MainActivity.this, "Update thành công!", Toast.LENGTH_SHORT).show();
                            ReadJson("http://192.168.1.7:81/sever/getData.php");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Update không thành công!", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("tenSV", ten);
                params.put("namsinhSV", String.valueOf(namsinh));
                params.put("diachiSV",diachi);
                params.put("idSV",String.valueOf(id));
                return params;
            }
        };
        queue.add(request);
    }
}