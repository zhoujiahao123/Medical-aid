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
//            case ResponseCons.STATUS_SUCCESS:
//                desc = ResponseCons.SUCCESS_MSG;
//                isSuccess = true;
//                break;
            case ResponseCons.STATUS_NO_THIS_DATA:
                desc = ResponseCons.NO_THIS_DATA_MSG;
                break;
            case ResponseCons.STATUS_FILED:
                desc = ResponseCons.FILED_MSG;
                break;
            case ResponseCons.STATUS_FALED_AES:
                desc = ResponseCons.FILED_AES_MSG;
                break;
            case ResponseCons.STATUS_FALED_NAME:
                desc = ResponseCons.FILED_NAME_MSG;
                break;
            case ResponseCons.STATUS_PASS_NAME:
                desc = ResponseCons.FILED_PASS_MSG;
                break;
            case ResponseCons.STATUS_REPEAT_NAME:
                desc = ResponseCons.REPEAT_NAME;
                break;
        }
        mStatusResult.status = status;
        mStatusResult.desc = desc;
        mStatusResult.isSuccess = isSuccess;
        return mStatusResult;
    }
}
