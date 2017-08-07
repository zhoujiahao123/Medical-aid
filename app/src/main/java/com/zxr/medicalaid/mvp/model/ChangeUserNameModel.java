package com.zxr.medicalaid.mvp.model;

import rx.Observable;

/**
 * Created by 猿人 on 2017/7/16.
 */

public interface ChangeUserNameModel  {
    Observable<String> changeUserName(String id, String newNickName);
}
