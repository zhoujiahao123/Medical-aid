package com.zxr.medicalaid.mvp.presenter;

import com.zxr.medicalaid.mvp.presenter.base.BasePresenter;

/**
 * Created by ASUS-NB on 2017/7/14.
 */

public interface CanclePresenter extends BasePresenter{
    void cancleLink(String doctorId,String patientId);
}
