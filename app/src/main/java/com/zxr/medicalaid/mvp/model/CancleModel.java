package com.zxr.medicalaid.mvp.model;

import com.zxr.medicalaid.mvp.entity.moudle.CancleInfo;

import rx.Observable;

/**
 * Created by ASUS-NB on 2017/7/14.
 */

public interface CancleModel {
    Observable<CancleInfo> cancleLink(String doctorId,String patientId);
}
