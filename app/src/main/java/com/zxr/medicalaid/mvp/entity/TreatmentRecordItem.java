package com.zxr.medicalaid.mvp.entity;

/**
 * Created by 猿人 on 2017/6/2.
 */

public class TreatmentRecordItem {
    private String time;
    private String prescription;

    public TreatmentRecordItem(String time, String prescription) {
        this.time = time;
        this.prescription = prescription;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
}
