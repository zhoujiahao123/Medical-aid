package com.zxr.medicalaid.mvp.presenter.base;

import android.support.annotation.NonNull;

import com.zxr.medicalaid.mvp.view.base.BaseView;

/**
 * Created by 猿人 on 2017/4/9.
 */

public interface BasePresenter {
    void onCreate();

    void injectView(@NonNull BaseView view);

}
