package com.zxr.medicalaid.mvp.model.ModelImpl;

import com.zxr.medicalaid.mvp.model.SignInModel;
import com.zxr.medicalaid.mvp.model.base.BaseModelImpl;

import rx.Observable;

/**
 * Created by ASUS-NB on 2017/7/7.
 */

public class SignInModelImpl extends BaseModelImpl implements SignInModel {
    @Override
    public Observable<String> signIn(String nickName, String password, String phoneNumber, String type) {
        return filterStatus(api.signIn(nickName,password,phoneNumber,type));
    }
}
