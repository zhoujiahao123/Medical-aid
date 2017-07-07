package com.zxr.medicalaid.mvp.model.ModelImpl;

import com.zxr.medicalaid.mvp.entity.moudle.DrugInfo;
import com.zxr.medicalaid.mvp.model.DrugInfoModel;
import com.zxr.medicalaid.mvp.model.base.BaseModelImpl;

import rx.Observable;

/**
 * Created by ASUS-NB on 2017/7/4.
 */

public class DrugInfoModelImpl extends BaseModelImpl implements DrugInfoModel {
    @Override
    public Observable<DrugInfo> getDrugInfo(String drugName) {
        return filterStatus(api.getDrugInfo(drugName));
    }
}
