package com.zxr.medicalaid.mvp.ui.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Vibrator;
import android.support.annotation.RequiresApi;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.MainViewActivity;

public class AlarmReceiver extends BroadcastReceiver {
    
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(final Context context, Intent intent) {
        //收到来自Alarm的消息
        String name = intent.getStringExtra("name");
        int num = intent.getIntExtra("num", -1);

        //设置震动
        final Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(new long[]{1000, 1000}, 0);
        //发送通知
        PendingIntent pd = PendingIntent.getActivity(context, 0, new Intent(context, MainViewActivity.class), 0);
        //在这里进行前台服务
        Notification.Builder builder = new Notification.Builder(context)
                .setOngoing(false)
                .setSmallIcon(R.drawable.welcome_logo)
                .setContentTitle("通知:")
                .setContentText("您的" + num + "号柜子的" + name + "已过期，请及时查看")
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pd)
                .setDefaults(Notification.DEFAULT_ALL);
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1, builder.build());

    }


}