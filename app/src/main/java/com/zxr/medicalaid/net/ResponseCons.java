package com.zxr.medicalaid.net;

/**
 * Created by 猿人 on 2017/5/23.
 */

public class ResponseCons {


    public static final String BASE_URL = "http://120.77.87.78:8080/igds/app/";
    public static final String IMAGE_URL = "";

    public static final String APP_KEY="1e1a6a2b63bf0";
    public static final String APP_SECRECT="6e550ec194b055c967e533bbf1b8f80d";





    public static final int STATUS_SUCCESS = 200;
    public static final String SUCCESS_MSG = "成功";

    public static final int STATUS_FILED = 500;
    public static final String FILED_MSG = "服务器出现问题";

    public static final int STATUS_FALED_AES=400;
    public static final String FILED_AES_MSG = "加密出现错误";

    public static final int STATUS_FALED_NAME=406;
    public static final String FILED_NAME_MSG="用户名被占用";

    public static final int STATUS_PASS_NAME=422;
    public static final String FILED_PASS_MSG="密码错误";
    public static String KEY_PASSWORD="nmid.igds.password";//密码加密密钥
    public static String KEY_NAME="nmid.igds.nick_name";//用户名加密密钥
    public static String KEY_PHONENUMBER="nmid.igds.phone_number";//电话号码加密密钥
}
