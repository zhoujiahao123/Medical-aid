package com.zxr.medicalaid.mvp.model.ModelImpl;

import com.zxr.medicalaid.mvp.entity.moudle.LinkInfo;
import com.zxr.medicalaid.mvp.model.LinkModel;
import com.zxr.medicalaid.mvp.model.base.BaseModelImpl;

import rx.Observable;

/**
 * Created by ASUS-NB on 2017/7/8.
 */

public class LinkModelImpl extends BaseModelImpl implements LinkModel {

    @Override
    public Observable<LinkInfo> linkDP(String doctorID, String patientId) {
        return api.linkDP(doctorID, patientId);
    }
}
