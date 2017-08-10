package com.zxr.medicalaid.mvp.presenter;

import com.zxr.medicalaid.mvp.presenter.base.BasePresenter;

/**
 * Created by 猿人 on 2017/7/16.
 */

public interface ChangeUserNamePresenter extends BasePresenter {
    void changUserName(String id,String newName);
}
