package com.zxr.medicalaid.utils.others;

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
    /**
     * 将文本转化为实践
     */
    public static long StrToTime(String str){
        String[] time = str.split(":");
        return Long.parseLong(time[0])*60*60+Long.parseLong(time[1])*60+Long.parseLong(time[2]);
    }
}