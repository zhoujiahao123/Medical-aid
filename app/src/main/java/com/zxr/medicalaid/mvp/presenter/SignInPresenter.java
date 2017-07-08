package com.zxr.medicalaid.mvp.presenter;

import com.zxr.medicalaid.mvp.presenter.base.BasePresenter;

/**
 * Created by ASUS-NB on 2017/7/7.
 */

public interface SignInPresenter extends BasePresenter {
    void signIn(String nickName, String password, String phoneNumber, String type);
}
