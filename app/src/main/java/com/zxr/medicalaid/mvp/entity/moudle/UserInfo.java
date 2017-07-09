package com.zxr.medicalaid.mvp.entity.moudle;

/**
 * Created by ASUS-NB on 2017/7/7.
 */

public class UserInfo {

    private String idString;
    private String nickName;
    private String phoneNumber;
    private String type;

    public String getIdString() {
        return idString;
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
