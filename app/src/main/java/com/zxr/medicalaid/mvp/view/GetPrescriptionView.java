package com.zxr.medicalaid.mvp.view;

import com.zxr.medicalaid.mvp.entity.moudle.PrescriptionInfo;
import com.zxr.medicalaid.mvp.view.base.BaseView;

/**
 * Created by ASUS-NB on 2017/8/3.
 */

public interface GetPrescriptionView extends BaseView{
    void getSucceed(PrescriptionInfo info);
}
