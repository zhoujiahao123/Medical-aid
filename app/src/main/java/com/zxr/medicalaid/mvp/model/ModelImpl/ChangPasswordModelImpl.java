package com.zxr.medicalaid.mvp.model.ModelImpl;

import com.zxr.medicalaid.mvp.model.base.BaseModelImpl;
import com.zxr.medicalaid.mvp.model.ChangPasswordModel;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by 猿人 on 2017/7/14.
 */

public class ChangPasswordModelImpl extends BaseModelImpl implements ChangPasswordModel {
    @Inject
    public ChangPasswordModelImpl() {
    }

    @Override
    public Observable<String> changPassword(String id, String oldPassword, String newPassword) {
        return filterStatus(api.changPassword(id,oldPassword,newPassword));
    }
}
