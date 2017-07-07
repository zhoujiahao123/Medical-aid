package com.zxr.medicalaid.mvp.ui.activities;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;

import static com.zxr.medicalaid.net.ResponseCons.APP_KEY;
import static com.zxr.medicalaid.net.ResponseCons.APP_SECRECT;


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

    private String countryCode ;
    private static final String code ="42";
    private String phoneNum;

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

        EventHandler eh = InitSDK();
        SMSSDK.registerEventHandler(eh); //注册短信回调
        countryCode = SMSSDK.getCountry(code)[1];
    }

    @NonNull
    private EventHandler InitSDK() {
        SMSSDK.initSDK(this, APP_KEY,APP_SECRECT);
        return new EventHandler(){
            @Override
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    Log.e("回调完成","回调完成");
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        Log.e("提交验证码成","成功");
                    }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                        Log.e("获取验证码成功","成功");
                    }else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){
                        //返回支持发送验证码的国家列表
                    }
                }else{
                    ((Throwable)data).printStackTrace();
                }
            }
        };
    }

    int seconds = 60;
    TimeCount time = new TimeCount(60 * 1000, 1000);

    @OnClick({R.id.identifying_number_send, R.id.confirm_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.identifying_number_send:

                phoneNum = mAccountEt.getText().toString();
                SMSSDK.getVerificationCode(countryCode,phoneNum,new OnSendMessageHandler() {
                    @Override
                    public boolean onSendMessage(String s, String s1) {
                        return false;
                    }
                });

                mSendCodeTv.setClickable(false);
                mSendCodeTv.setText(seconds + "s后可重新发送");
                //开启及时
                time.start();
                break;
            case R.id.confirm_bt:

                Log.e("TAG","点了");
                SMSSDK.submitVerificationCode(SMSSDK.getCountry("42")[1],mAccountEt.getText().toString(),mIdentifyintEt.getText().toString());

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
