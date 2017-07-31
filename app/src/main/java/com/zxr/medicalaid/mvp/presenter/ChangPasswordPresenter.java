package com.zxr.medicalaid.mvp.presenter;

import com.zxr.medicalaid.mvp.presenter.base.BasePresenter;

/**
 * Created by 猿人 on 2017/7/14.
 */

public interface ChangPasswordPresenter extends BasePresenter {
    void changPassword(String id,String oldPassword,String newPassword);
}
