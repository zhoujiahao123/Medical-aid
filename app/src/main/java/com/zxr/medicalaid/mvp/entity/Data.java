package com.zxr.medicalaid.mvp.entity;

/**
 * Created by 猿人 on 2017/4/12.
 */

public class Data<T> {
    private int code;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
