package com.zxr.medicalaid.mvp.ui.activities;

import android.content.Intent;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.utils.system.ToActivityUtil;
import com.zxr.medicalaid.zxing.CaptureActivity;

public class QRActivity extends BaseActivity {
    public final static int SCANNING_REQUEST_CODE = 1;

    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        Intent qrReaderIntent = new Intent(QRActivity.this, CaptureActivity.class);
        qrReaderIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(qrReaderIntent,SCANNING_REQUEST_CODE);
    }

    private void alreadyConnect() {
        ToActivityUtil.toNextActivity(this, CaptureActivity.class,
                new String[]{CurrentPatientsActivity.GET_FROM}, new int[]{CurrentPatientsActivity.PATIENT});
        finish();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SCANNING_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    //在这个发起网络请求连接医师
                }
                break;
            default:
                break;
        }
    }
    @Override
    public int getLayout() {
        return R.layout.activity_qr;
    }

}
