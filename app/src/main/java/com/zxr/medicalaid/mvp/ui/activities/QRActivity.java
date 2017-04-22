package com.zxr.medicalaid.mvp.ui.activities;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.utils.system.ToActivityUtil;

public class QRActivity extends BaseActivity {

    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        findViewById(R.id.text_bt).setOnClickListener(
                v->{
                    ToActivityUtil.toNextActivity(this,PrescribeActivity.class,
                            new String[]{PrescribeActivity.GET_FROM},new int[]{PrescribeActivity.PATIENT});
                    finish();});
    }

    @Override
    public int getLayout() {
        return R.layout.activity_qr;
    }
}
