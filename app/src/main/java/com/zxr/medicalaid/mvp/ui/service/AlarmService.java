package com.zxr.medicalaid.mvp.ui.service;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

import com.zxr.medicalaid.MedicalDateInfo;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.MainViewActivity;
import com.zxr.medicalaid.utils.db.DbUtil;
import com.zxr.medicalaid.utils.others.TimeUtils;

import java.util.List;

public class AlarmService extends Service {
    //===============================================数据库操作对象
    private AlarmManager am;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        am = (AlarmManager) getSystemService(ALARM_SERVICE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        //保证sesrvice的远东anr安全
        //进行数据库的检索
        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
              setUpAlarm();
            }
        }).start();
        //检索完成开始进行闹钟的设置
        return super.onStartCommand(intent, flags, startId);
    }
    

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void setUpAlarm(){
        List<MedicalDateInfo> list =  DbUtil.getDaosession().getMedicalDateInfoDao().loadAll();
        if(list != null && list.size() >0){
            for(MedicalDateInfo medicalDateInfo : list){
                
                long alarmMills = TimeUtils.DateToMills(medicalDateInfo.getProductDate())+TimeUtils.ShelfLifeToMills(medicalDateInfo.getShelfLife());
                if (alarmMills < System.currentTimeMillis()){
                    //在这里进行前台服务
                    PendingIntent pd = PendingIntent.getActivity(this, 0, new Intent(this, MainViewActivity.class), 0);
                    Notification.Builder builder = new Notification.Builder(this)
                            .setOngoing(false)
                            .setSmallIcon(R.drawable.welcome_logo)
                            .setContentTitle("通知:")
                            .setContentText("您的" + medicalDateInfo.getDrawerNum() + "号柜子的" + medicalDateInfo.getName() + "已过期，请及时查看")
                            .setWhen(System.currentTimeMillis())
                            .setContentIntent(pd)
                            .setDefaults(Notification.DEFAULT_VIBRATE);
                    NotificationManager nm = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
                    nm.notify(medicalDateInfo.getDrawerNum() ,builder.build());
                    continue;
                }
                Intent intent1 = new Intent(AlarmService.this, AlarmReceiver.class);
                intent1.putExtra("name",medicalDateInfo.getName());
                intent1.putExtra("num",medicalDateInfo.getDrawerNum());
                PendingIntent sender = PendingIntent.getBroadcast(AlarmService.this,medicalDateInfo.getDrawerNum(),intent1,0);
                am.setExact(AlarmManager.RTC_WAKEUP, TimeUtils.DateToMills(medicalDateInfo.getProductDate())+TimeUtils.DateToMills(medicalDateInfo.getShelfLife()),sender);
            }
        }
    }
}