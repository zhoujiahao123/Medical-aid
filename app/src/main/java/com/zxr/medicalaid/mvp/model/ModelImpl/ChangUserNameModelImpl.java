package com.zxr.medicalaid.mvp.model.ModelImpl;

import com.zxr.medicalaid.mvp.model.base.BaseModelImpl;
import com.zxr.medicalaid.mvp.model.ChangeUserNameModel;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by 猿人 on 2017/7/16.
 */

public class ChangUserNameModelImpl extends BaseModelImpl implements ChangeUserNameModel {
    @Inject
    public ChangUserNameModelImpl() {
    }

    @Override
    public Observable<String> changeUserName(String id, String newNickName) {
        return filterStatus(api.changName(id, newNickName));
    }
}
