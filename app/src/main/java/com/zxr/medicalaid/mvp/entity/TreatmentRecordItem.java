package com.zxr.medicalaid.mvp.entity;

/**
 * Created by 猿人 on 2017/6/2.
 */

public class TreatmentRecordItem {
    private String time;

    public TreatmentRecordItem(String time, String prescription) {
        this.time = time;

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
