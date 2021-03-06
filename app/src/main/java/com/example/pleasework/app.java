package com.example.pleasework;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

//what is this??


public class app extends Application {
    public static final String CHANNEL_ID = "play in notification";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }


    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel playnotification = new NotificationChannel(
                    CHANNEL_ID,
                    "plays",
                    NotificationManager.IMPORTANCE_HIGH
            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(playnotification);
        }
    }
}