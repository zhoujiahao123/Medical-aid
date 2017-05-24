package com.zxr.medicalaid.mvp.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.base.RxBusSubscriberBaseActivity;
import com.zxr.medicalaid.utils.system.RxBus;
import com.zxr.medicalaid.utils.system.ToActivityUtil;

import butterknife.InjectView;
import butterknife.OnClick;
import rx.functions.Action1;

public class LoginActivity extends RxBusSubscriberBaseActivity {

    @InjectView(R.id.account_input)
    EditText mAccountEt;
    @InjectView(R.id.password_input)
    EditText mPasswordEt;
    @InjectView(R.id.login_bt)
    Button mLoginBt;
    @InjectView(R.id.register_bt)
    Button mRegisterBt;


    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }


    @Override
    public void initRxBus() {
        mSubscription = RxBus.getDefault().toObservable(String.class)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.login_bt, R.id.register_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_bt:
                ToActivityUtil.toNextActivityAndFinish(this, MainViewActivity.class);
                break;
            case R.id.register_bt:
                ToActivityUtil.toNextActivity(this, RegisterActivity.class);
                break;
        }
    }
}
