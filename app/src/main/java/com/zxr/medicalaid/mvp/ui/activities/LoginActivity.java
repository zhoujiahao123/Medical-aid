package com.zxr.medicalaid.mvp.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.presenter.presenterImpl.LogInPresenterImpl;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.mvp.view.LogInView;
import com.zxr.medicalaid.net.ResponseCons;
import com.zxr.medicalaid.utils.db.DbUtil;
import com.zxr.medicalaid.utils.encode.EncodeUtil;
import com.zxr.medicalaid.utils.system.ToActivityUtil;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LogInView{
    MessageDigest md ;
    @InjectView(R.id.account_input)
    EditText mAccountEt;
    @InjectView(R.id.password_input)
    EditText mPasswordEt;
    @InjectView(R.id.login_bt)
    Button mLoginBt;
    @InjectView(R.id.register_bt)
    Button mRegisterBt;
    @Inject
    LogInPresenterImpl presenter;

    @Override
    public void initInjector() {
        mActivityComponent.inject(this);
        presenter.injectView(this);
    }

    @Override
    public void initViews() {
        if(DbUtil.getDaosession().getUserDao().loadAll().size() != 0){
            ToActivityUtil.toNextActivityAndFinish(this,MainViewActivity.class);
        }
    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
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
//                ToActivityUtil.toNextActivityAndFinish(this, MainViewActivity.class);
                if(!(mAccountEt.getText().toString().equals("")||mPasswordEt.getText().toString().equals(""))){
                    if(isNetWork()){
                        String name = doEncrypt(mAccountEt.getText().toString(), ResponseCons.KEY_PHONENUMBER);
                        String password = doEncrypt(mPasswordEt.getText().toString(),ResponseCons.KEY_PASSWORD);
                        presenter.logIn(name,password);
                    }else {
                        Toast.makeText(this,"请检查您的网络设置",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this,"信息不能为空",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.register_bt:
                ToActivityUtil.toNextActivity(this, RegisterActivity.class);
                break;
        }
    }
    public  String doEncrypt(String data,String keyString){
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //生成字节Key
        byte[] byteKey = md.digest(keyString.getBytes());
        //Key转换
        Key convertKey = new SecretKeySpec(byteKey, "AES");
        Key myKey=convertKey;
        try {
            //加密
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, myKey);
            byte[] encode = cipher.doFinal(data.getBytes());
            String encodeString = EncodeUtil.byte2hex(encode);
            return encodeString;
        }
        catch (Exception e){
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
        ToActivityUtil.toNextActivityAndFinish(this, MainViewActivity.class);
    }
}
