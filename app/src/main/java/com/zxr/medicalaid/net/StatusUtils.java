package com.zxr.medicalaid.net;

/**
 * Created by 猿人 on 2017/5/23.
 */

public class StatusUtils {
    public static class StatusResult{
        public int status;
        public String desc;
        public boolean isSuccess;
    }
    private static StatusResult mStatusResult = new StatusResult();
    public static StatusResult judgeStatus(int status) {
        String desc = "";
        boolean isSuccess = false;
        switch (status) {
            case ResponseCons.STATUS_SUCCESS:
                desc = ResponseCons.SUCCESS_MSG;
                isSuccess = true;
                break;
            case ResponseCons.STATUS_FILED:
                desc = ResponseCons.FILED_MSG;
                break;
        }
        mStatusResult.status = status;
        mStatusResult.desc = desc;
        mStatusResult.isSuccess = isSuccess;
        return mStatusResult;
    }
}
