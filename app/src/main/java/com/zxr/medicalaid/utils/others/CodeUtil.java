package com.zxr.medicalaid.utils.others;

/**
 * Created by ASUS-NB on 2017/7/15.
 */

public class CodeUtil {
    public static String codeCheck(int code){
        switch (code){
            case 200:
            case 201:
            case 204:
                return "OK";
            case 400:
                return "请求参数出现错误";

            case 401:
                return "没有权限，具体指患者没有权限执行医生的操作";

            case 403:
                return "重复操作";

            case 404:
                return "数据未找到";

            case 410:
                return "请求资源以删除";

            case 422:
                return "验证错误";

            case 500:
                return "服务器错误";

            default:return "";
        }

    }
}
