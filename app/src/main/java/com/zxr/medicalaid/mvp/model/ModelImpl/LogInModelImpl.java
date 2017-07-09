package com.zxr.medicalaid.mvp.model.ModelImpl;

import com.zxr.medicalaid.mvp.entity.moudle.UserInfo;
import com.zxr.medicalaid.mvp.model.LogInModel;
import com.zxr.medicalaid.mvp.model.base.BaseModelImpl;

import rx.Observable;

/**
 * Created by ASUS-NB on 2017/7/7.
 */

public class LogInModelImpl extends BaseModelImpl implements LogInModel {
    @Override
    public Observable<UserInfo> logIn(String nickName, String password) {
        return api.logIn(nickName,password);
    }
}
