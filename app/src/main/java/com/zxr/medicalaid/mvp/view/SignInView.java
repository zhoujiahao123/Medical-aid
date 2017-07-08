package com.zxr.medicalaid.mvp.view;

import com.zxr.medicalaid.mvp.view.base.BaseView;

/**
 * Created by ASUS-NB on 2017/7/7.
 */

public interface SignInView extends BaseView{
    void signIn(String nickName, String password, String phoneNumber, String type);

}
