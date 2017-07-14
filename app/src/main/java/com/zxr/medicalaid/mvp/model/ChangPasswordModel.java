package com.zxr.medicalaid.mvp.model;

import rx.Observable;

/**
 * Created by 猿人 on 2017/7/14.
 */

public interface ChangPasswordModel {
    Observable<String> changPassword(String id, String oldPassword, String newPassword);
}
