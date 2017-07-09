package com.zxr.medicalaid.mvp.entity.moudle;

/**
 * Created by ASUS-NB on 2017/7/8.
 */

public class LinkInfo {
    /**
     * code : 201
     * message : CREATED#新建或修改资源成功
     * body :
     */

    private int code;
    private String message;
    private String body;

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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
