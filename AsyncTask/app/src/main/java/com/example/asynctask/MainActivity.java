package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button conform;
    TextView context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        conform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CongViec().execute();
            }
        });
    }
    void AnhXa() {
        conform = (Button) findViewById(R.id.start);
        context = (TextView) findViewById(R.id.context);
    }

    class CongViec extends AsyncTask<Void, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            context.setText("Start.\n");
        }

        @Override
        protected String doInBackground(Void... voids) {
            for(int i=1;i<=5;i++){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress("Done work "+i+".\n");
            }
            return "Done.";
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            super.onPostExecute(s);
            context.append(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            context.append(values[0]);
        }
    }
}