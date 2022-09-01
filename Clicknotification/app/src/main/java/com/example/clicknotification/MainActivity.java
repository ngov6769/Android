package com.example.clicknotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button sendbtn, nextbtn;
    private final String KEY_NOTIFICATION = "notification";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendbtn = findViewById(R.id.sendnotification);
        nextbtn = findViewById(R.id.next);
        createNotificationChannel();
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotification();
            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void createNotification() {
        Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
        TaskStackBuilder stack = TaskStackBuilder.create(getApplicationContext());
        stack.addNextIntentWithParentStack(intent);
        PendingIntent pendingIntent = stack.getPendingIntent(1,PendingIntent.FLAG_CANCEL_CURRENT);

        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_notifications);

        NotificationCompat.Builder data = new NotificationCompat.Builder(MainActivity.this,KEY_NOTIFICATION);
        data.setContentTitle("Thong bao!");
        data.setSmallIcon(R.drawable.ic_notifications);
        data.setContentText("Khong co thong bao nao");
        data.setLargeIcon(bitmap);
        data.setContentIntent(pendingIntent);
        data.setSound(uri);
        data.setAutoCancel(true);
        data.build();

        NotificationManagerCompat manager = NotificationManagerCompat.from(MainActivity.this);
        manager.notify(1,data.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();
            NotificationChannel channel = new NotificationChannel(KEY_NOTIFICATION,"My notification", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setSound(uri,attributes);
            NotificationManager manager = getSystemService(NotificationManager.class);
            if(manager!=null) manager.createNotificationChannel(channel);
        }
    }
}