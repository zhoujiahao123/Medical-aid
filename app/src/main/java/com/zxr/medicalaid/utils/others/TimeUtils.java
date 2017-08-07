package com.zxr.medicalaid.utils.others;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeUtils {
    public static long DateToMills(String dateTime){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        if(dateTime != null){
            try {
                calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateTime));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return calendar.getTimeInMillis();
    }
    public static long ShelfLifeToMills(String dateTime){
        Log.i("TAG",dateTime);
        //进行整数年的反转
        if (dateTime.length() == 2){
            //说明只有年
            int year = Integer.parseInt(dateTime.substring(0,1));
            year -= 1;
            dateTime = year+"年"+"12月";
        }
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        if(dateTime != null){
            try {
                calendar.setTime(new SimpleDateFormat("yy年MM月").parse(dateTime));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return calendar.getTimeInMillis();
    }
    
    /**
     * 将文本转化为实践
     */
    public static long StrToTime(String str){
        String[] time = str.split(":");
        return Long.parseLong(time[0])*60*60+Long.parseLong(time[1])*60+Long.parseLong(time[2]);
    }
}