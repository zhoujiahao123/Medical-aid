package com.zxr.medicalaid.mvp.entity;

/**
 * Created by 猿人 on 2017/4/21.
 */

public class Person {
    private String name;
    private String time;
    private String image_url;

    public Person(String name, String time, String image_url) {
        this.name = name;
        this.time = time;
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
