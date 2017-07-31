package com.zxr.medicalaid.mvp.model;

import com.zxr.medicalaid.mvp.entity.moudle.UserInfo;

import rx.Observable;

/**
 * Created by ASUS-NB on 2017/7/5.
 */

public interface LogInModel  {
    Observable<UserInfo> logIn(String nickName, String password);
}
