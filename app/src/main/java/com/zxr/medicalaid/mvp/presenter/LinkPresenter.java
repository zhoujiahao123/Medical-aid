package com.zxr.medicalaid.mvp.presenter;

import com.zxr.medicalaid.mvp.presenter.base.BasePresenter;

/**
 * Created by ASUS-NB on 2017/7/8.
 */

public interface LinkPresenter extends BasePresenter {
    void linkDP(String doctorId,String patientId);
}
