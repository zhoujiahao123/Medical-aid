package com.zxr.medicalaid.mvp.model.ModelImpl;

import com.zxr.medicalaid.mvp.entity.moudle.CancleInfo;
import com.zxr.medicalaid.mvp.model.CancleModel;
import com.zxr.medicalaid.mvp.model.base.BaseModelImpl;

import rx.Observable;

/**
 * Created by ASUS-NB on 2017/7/14.
 */

public class CancleModelImpl extends BaseModelImpl implements CancleModel {
    @Override
    public Observable<CancleInfo> cancleLink(String doctorId, String patientId) {
        return api.cancleLink(doctorId,patientId);
    }
}
