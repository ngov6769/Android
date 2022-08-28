package com.example.appchat;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {
    private ListView user,chat;
    private EditText nhap;
    private ImageView adduser,send;
    Socket socket;
    ArrayAdapter adapter,adapterChat;
    ArrayList<String> stringArrayList,stringArrayListChat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        socketIO();
        onAddUser();
        createListUser();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nhap.getText().toString().length()>0) {
                    socket.emit("client-send-chat", nhap.getText().toString());
                }
            }
        });
    }
    private void createListUser() {
        stringArrayList = new ArrayList<>();
        stringArrayListChat = new ArrayList<>();
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,stringArrayList);
        user.setAdapter(adapter);
        adapterChat = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,stringArrayListChat);
        chat.setAdapter(adapterChat);
    }

    private void onAddUser() {
        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nhap.getText().toString().trim().length()>0) {
                    socket.emit("client-register-user", nhap.getText().toString());
                }
            }
        });
    }

    private void socketIO() {
        try {
            socket = IO.socket("http://192.168.1.7:3000/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        socket.connect();
        socket.on("server-send-data",onRetrieveData);
        socket.on("server-send-user",onListUser);
        socket.on("server-send-chat",onSendChat);
        //socket.emit("client-sent-data","Hoc lap trinh Android");
    }

    Emitter.Listener onListUser = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                        JSONArray array = object.getJSONArray("danhsach");
                        stringArrayList.clear();
                        for(int i=0;i<array.length();i++){
                            //stringArrayList.clear();
                            String listUser = array.getString(i);
                            stringArrayList.add(listUser);
                            adapter.notifyDataSetChanged();
                            //Toast.makeText(MainActivity.this, listUser+"", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };
    Emitter.Listener onRetrieveData = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                        boolean exits = object.getBoolean("ketqua");
                        if(exits==false) {
                            Toast.makeText(MainActivity.this, "Dang ki user thanh cong", Toast.LENGTH_SHORT).show();
                        }else Toast.makeText(MainActivity.this, "Tai khoan da ton tai", Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };
    Emitter.Listener onSendChat = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                        String context = object.getString("chatcontent");
                        stringArrayListChat.add(context);
                        adapterChat.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };
    private void anhXa(){
        user = findViewById(R.id.list_user);
        chat = findViewById(R.id.chat);
        nhap = findViewById(R.id.nhap);
        adduser = findViewById(R.id.user);
        send = findViewById(R.id.send);
    }
}