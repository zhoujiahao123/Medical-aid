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
                    ToActivityUtil.toNextActivity(this,CurrentPatientsActivity.class,
                            new String[]{CurrentPatientsActivity.GET_FROM},new int[]{CurrentPatientsActivity.PATIENT});
                    finish();});
    }

    @Override
    public int getLayout() {
        return R.layout.activity_qr;
    }
}
