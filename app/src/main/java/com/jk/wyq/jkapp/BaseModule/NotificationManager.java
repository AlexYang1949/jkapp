package com.jk.wyq.jkapp.BaseModule;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.jk.wyq.jkapp.R;

public class NotificationManager {
    public static void addAlert(Context context,String date,String content){
        Intent hangIntent = new Intent(context, MainActivity.class);
        PendingIntent hangPendingIntent = PendingIntent.getActivity(context, 0, hangIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
        Notification notification = mBuilder.setContentTitle(context.getResources().getString(R.string.app_name))
                .setContentText("喝水")
                .setContentTitle("健康提示")
                .setSmallIcon(R.mipmap.logo)
                .setWhen(1524134180)//通知产生的时间，会在通知信息里显示
                .setContentIntent(hangPendingIntent)
                .build();
        android.app.NotificationManager mNotificationManager = (android.app.NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());
    }
}
