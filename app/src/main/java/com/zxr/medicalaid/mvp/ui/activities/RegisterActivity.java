package com.zxr.medicalaid.mvp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.presenter.presenterImpl.SignInPresenterImpl;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.mvp.view.SignInView;
import com.zxr.medicalaid.utils.encode.EncodeUtil;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;

import static com.zxr.medicalaid.net.ResponseCons.APP_KEY;
import static com.zxr.medicalaid.net.ResponseCons.APP_SECRECT;
import static com.zxr.medicalaid.net.ResponseCons.KEY_NAME;
import static com.zxr.medicalaid.net.ResponseCons.KEY_PASSWORD;
import static com.zxr.medicalaid.net.ResponseCons.KEY_PHONENUMBER;


public class RegisterActivity extends BaseActivity implements SignInView {

    MessageDigest md;
    @Inject
    SignInPresenterImpl presenter;
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
    @InjectView(R.id.container)
    ConstraintLayout container;
    @InjectView(R.id.doctor)
    RadioButton doctor;
    @InjectView(R.id.patient)
    RadioButton patient;
    @InjectView(R.id.name_input)
    EditText mNameInput;

    private String countryCode;
    private static final String code = "42";
    private String phoneNum;
    //用于数据加密

    private static String TAG = "RegisterActivity";

    @Override
    public void initInjector() {
        mActivityComponent.inject(this);
        presenter.injectView(this);
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
        SMSSDK.initSDK(this, APP_KEY, APP_SECRECT);
        return new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    Log.e("回调完成", "回调完成");
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        Log.e("提交验证码成", "成功");
//                        String name= doEncrypt(String.valueOf(Math.random()*100));
                        String name = doEncrypt(mNameInput.getText().toString().trim(),KEY_NAME);
                        String password = doEncrypt(mPasswordEt.getText().toString().trim(), KEY_PASSWORD);
                        String phoneNumber = doEncrypt(mAccountEt.getText().toString().trim(), KEY_PHONENUMBER);
                        String type = "doctor";
                        if (patient.isChecked()){
                            type = "patient";
                        }
                        presenter.signIn(name, password, phoneNumber, type);
                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {

                    } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                        //返回支持发送验证码的国家列表
                    }
                } else {
                    ((Throwable) data).printStackTrace();
                }
            }
        };
    }

    int seconds = 60;
    TimeCount time = new TimeCount(60 * 1000, 1000);

    /**
     * 加密算法
     *
     * @param
     */


    @OnClick({R.id.identifying_number_send, R.id.confirm_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.identifying_number_send:
                phoneNum = mAccountEt.getText().toString();
                if (mAccountEt.getText() != null) {
                    SMSSDK.getVerificationCode(countryCode, phoneNum, new OnSendMessageHandler() {
                        @Override
                        public boolean onSendMessage(String s, String s1) {
                            return false;
                        }
                    });
                }
                mSendCodeTv.setClickable(false);
                mSendCodeTv.setText(seconds + "s后可重新发送");
                //开启及时
                time.start();
                break;
            case R.id.confirm_bt:
                if (mAccountEt.getText() != null && mPasswordEt.getText() != null) {
                    if (isNetWork()) {
                        SMSSDK.submitVerificationCode(SMSSDK.getCountry("42")[1], mAccountEt.getText().toString(), mIdentifyintEt.getText().toString());
//                        String type = "doctor";
//                        if (patient.isChecked()){
//                            type = "patient";
//                        }
//                        String name = doEncrypt(mNameInput.getText().toString(), KEY_NAME);
//                        String password = doEncrypt(mPasswordEt.getText().toString().trim(), KEY_PASSWORD);
//                        String phoneNumber = doEncrypt(mAccountEt.getText().toString().trim(), KEY_PHONENUMBER);
//                        Log.e(TAG,name);
//                        Log.e(TAG,password);
//                        Log.e(TAG,phoneNumber);
                    } else {
                        Snackbar.make(container, "请检查您的网络连接", Snackbar.LENGTH_SHORT).show();
                    }
                } else {
                    Snackbar.make(container, "信息不能为空", Snackbar.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public String doEncrypt(String data, String keyString) {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //生成字节Key
        byte[] byteKey = md.digest(keyString.getBytes());
        //Key转换
        Key convertKey = new SecretKeySpec(byteKey, "AES");
        Key myKey = convertKey;
        try {
            //加密
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, myKey);
            byte[] encode = cipher.doFinal(data.getBytes());
            String encodeString = EncodeUtil.byte2hex(encode);
            return encodeString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMsg(String msg) {
        if (msg.equals("OK")) {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            intent.putExtra("phoneNumber", mAccountEt.getText().toString().trim());
            startActivity(intent);
            finish();
        } else {
            Snackbar.make(container, "请求服务器出现了一点问题", Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void signIn(String nickName, String password, String phoneNumber, String type) {

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
