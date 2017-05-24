package com.zxr.medicalaid.mvp.view.base;

/**
 * Created by 猿人 on 2017/4/9.
 */

public interface BaseView {
    void showProgress();

    void hideProgress();

    void showMsg(String msg);
}
