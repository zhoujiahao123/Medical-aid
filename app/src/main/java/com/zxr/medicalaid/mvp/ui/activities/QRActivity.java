package com.zxr.medicalaid.mvp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.presenter.presenterImpl.LinkPresenterImpl;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.mvp.view.LinkView;
import com.zxr.medicalaid.utils.encode.EncodeUtil;
import com.zxr.medicalaid.utils.system.ToActivityUtil;
import com.zxr.medicalaid.zxing.CaptureActivity;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;

public class QRActivity extends BaseActivity  implements LinkView{
    public final static int SCANNING_REQUEST_CODE = 1;
    @Inject
    LinkPresenterImpl presenter;

    @Override
    public void initInjector() {
        mActivityComponent.inject(this);
        presenter.injectView(this);
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
                    Bundle bundle = data.getExtras();
                    String doctorId= bundle.getString("result");
                    presenter.linkDP("c296ef212d6688cc128f57e74092c5130","bdad28020ab0bd0be8431dc22b82f7c87");
                    Log.e(TAG,doctorId);
                }
                break;
            default:
                break;
        }
    }
    MessageDigest md ;
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
    public int getLayout() {
        return R.layout.activity_qr;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMsg(String msg) {
        Log.e(TAG,"OKla ");
    }
}
