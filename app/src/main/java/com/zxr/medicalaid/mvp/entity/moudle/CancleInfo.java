package com.zxr.medicalaid.mvp.entity.moudle;

/**
 * Created by ASUS-NB on 2017/7/14.
 */

public class CancleInfo {
    /**
     * code : 204
     * message : NO_CONTENT#删除数据成功
     * body : null
     */

    private int code;
    private String message;
    private Object body;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
