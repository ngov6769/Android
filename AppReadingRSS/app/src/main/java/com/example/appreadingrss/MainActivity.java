package com.example.appreadingrss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView danhsach;
    ArrayList <String> tieudearray,linkarray;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        danhsach = (ListView) findViewById(R.id.danhsach);
        tieudearray = new ArrayList<>();
        linkarray = new ArrayList<>();
        adapter=new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,tieudearray);
        danhsach.setAdapter(adapter);
        danhsach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                //Toast.makeText(MainActivity.this, linkarray.get(i), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,MainActivity_2.class);
                intent.putExtra("linkweb",linkarray.get(i));
                startActivity(intent);
            }
        });
        new AppReadingRSS().execute("https://vnexpress.net/rss/so-hoa.rss");
    }
    private class AppReadingRSS extends AsyncTask<String,Void,String>{
        StringBuffer content = new StringBuffer();
        String line = "";
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while((line = bufferedReader.readLine()) != null){
                    content.append(line+"\n");
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            XMLDOMParser xmldomParser =new XMLDOMParser();
            Document document = xmldomParser.getDocument(s);
            NodeList nodeList = document.getElementsByTagName("item");
            String tieude = "";
            String link = "";
            for(int i=0;i<nodeList.getLength();i++){
                Element element = (Element) nodeList.item(i);
                tieude = xmldomParser.getValue(element,"title");
                link = xmldomParser.getValue(element,"link");
                tieudearray.add(tieude);
                linkarray.add(link);
            }
            adapter.notifyDataSetChanged();
        }
    }
}