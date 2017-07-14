package com.zxr.medicalaid.mvp.model.ModelImpl;

import com.zxr.medicalaid.mvp.model.QbImageModel;
import com.zxr.medicalaid.mvp.model.base.BaseModelImpl;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 猿人 on 2017/7/13.
 */

public class QbImageModelImpl extends BaseModelImpl implements QbImageModel {

    @Inject
    public QbImageModelImpl() {
    }

    @Override
    public Observable<ResponseBody> getQBImage(String id) {
        return api.getQBImg(id);
    }
}
