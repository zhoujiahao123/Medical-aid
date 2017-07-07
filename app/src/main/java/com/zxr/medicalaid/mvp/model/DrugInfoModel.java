package com.zxr.medicalaid.mvp.model;

import com.zxr.medicalaid.mvp.entity.moudle.DrugInfo;

import rx.Observable;

/**
 * Created by ASUS-NB on 2017/7/4.
 */

public interface DrugInfoModel   {
    Observable<DrugInfo> getDrugInfo(String drugName);
}
