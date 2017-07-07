package com.zxr.medicalaid.net;

/**
 * Created by 猿人 on 2017/5/23.
 */

public class ApiException extends RuntimeException {
    public ApiException(int status){
        super(getErrorDes(status));
    }
    private static String getErrorDes(int status){
        return StatusUtils.judgeStatus(status).desc;
    }
}
