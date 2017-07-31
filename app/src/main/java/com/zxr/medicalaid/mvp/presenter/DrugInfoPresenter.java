package com.zxr.medicalaid.mvp.presenter;

import com.zxr.medicalaid.mvp.presenter.base.BasePresenter;

/**
 * Created by ASUS-NB on 2017/7/4.
 */

public interface DrugInfoPresenter extends BasePresenter{
    void getDrugInfo(String drugName);
}
