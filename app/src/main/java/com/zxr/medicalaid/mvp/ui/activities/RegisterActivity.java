package com.zxr.medicalaid.mvp.ui.activities;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {


    @InjectView(R.id.acount_input)
    EditText mAccountEt;
    @InjectView(R.id.password_input)
    EditText mPasswordEt;
    @InjectView(R.id.identifying_number_input)
    EditText mIdentifyintEt;
    @InjectView(R.id.confirm_bt)
    Button mConfirmBt;
    @InjectView(R.id.identifying_number_send)
    TextView mSendCodeTv;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }

    int seconds = 60;
    TimeCount time = new TimeCount(60 * 1000, 1000);

    @OnClick({R.id.identifying_number_send, R.id.confirm_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.identifying_number_send:
                mSendCodeTv.setClickable(false);
                mSendCodeTv.setText(seconds + "s后可重新发送");
                //开启及时
                time.start();
                break;
            case R.id.confirm_bt:
                break;
        }
    }

    /**
     * 计时类
     */
    
    class TimeCount extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            mSendCodeTv.setText(--seconds + "s后可重新发送");
        }

        @Override
        public void onFinish() {
            seconds = 60;
            mSendCodeTv.setText("发送");
            mSendCodeTv.setClickable(true);
        }
    }

}
