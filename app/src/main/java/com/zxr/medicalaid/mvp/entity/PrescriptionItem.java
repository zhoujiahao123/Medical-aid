package com.zxr.medicalaid.mvp.entity;

/**
 * Created by 猿人 on 2017/6/2.
 */

public class PrescriptionItem {

    private String name;
    private String weight;

    public PrescriptionItem(String name, String weight) {
        this.weight = weight;
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
