package com.zxr.medicalaid.mvp.entity.moudle;

/**
 * Created by ASUS-NB on 2017/7/7.
 */

public class UserInfo {

    /**
     * code : 200
     * message : OK
     * body : {"idString":"e0aab76a3c5da8b4a7dd1611feefa7bb7","nickName":"15340504857","phoneNumber":"15340504857","type":"doctor"}
     */

    private int code;
    private String message;
    /**
     * idString : e0aab76a3c5da8b4a7dd1611feefa7bb7
     * nickName : 15340504857
     * phoneNumber : 15340504857
     * type : doctor
     */

    private BodyBean body;

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

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
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
}
