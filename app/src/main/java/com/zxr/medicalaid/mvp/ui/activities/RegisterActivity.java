package com.zxr.medicalaid.mvp.ui.activities;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;

import butterknife.InjectView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {


    @InjectView(R.id.acount_input)
    EditText mAccountEt;
    @InjectView(R.id.password_input)
    EditText mPasswordEt;
    @InjectView(R.id.identifying_number_input)
    EditText mIdentifyintEt;
    @InjectView(R.id.identifying_number_image)
    ImageView mIdentifyingImage;
    @InjectView(R.id.confirm_bt)
    Button mConfirmBt;

    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_register;
    }

    @OnClick(R.id.confirm_bt)
    public void onViewClicked() {

    }
}
