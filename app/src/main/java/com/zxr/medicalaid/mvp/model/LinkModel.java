package com.zxr.medicalaid.mvp.model;

import com.zxr.medicalaid.mvp.entity.moudle.LinkInfo;

import rx.Observable;

/**
 * Created by ASUS-NB on 2017/7/8.
 */

public interface LinkModel {
    Observable<LinkInfo> linkDP(String doctorID,String patientId);
}
