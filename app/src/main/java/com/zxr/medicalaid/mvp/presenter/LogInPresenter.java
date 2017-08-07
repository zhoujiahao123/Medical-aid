package com.zxr.medicalaid.mvp.presenter;

import com.zxr.medicalaid.mvp.presenter.base.BasePresenter;

/**
 * Created by ASUS-NB on 2017/7/7.
 */

public interface LogInPresenter extends BasePresenter{
    void logIn(String nickName,String password);
}
