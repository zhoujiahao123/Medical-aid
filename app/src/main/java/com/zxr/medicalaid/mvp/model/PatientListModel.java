package com.zxr.medicalaid.mvp.model;

import com.zxr.medicalaid.mvp.entity.moudle.PatientInfo;

import rx.Observable;

/**
 * Created by ASUS-NB on 2017/7/13.
 */

public interface PatientListModel {
    Observable<PatientInfo> getPatient(String doctorId,int currentPage);
}
