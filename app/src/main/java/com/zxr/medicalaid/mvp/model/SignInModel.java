package com.zxr.medicalaid.mvp.model;

import rx.Observable;

/**
 * Created by ASUS-NB on 2017/7/7.
 */

public interface SignInModel {
    Observable<String> signIn(String nickName, String password, String phoneNumber, String type);
}
