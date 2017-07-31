package com.zxr.medicalaid.mvp.ui.fragments.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by 猿人 on 2017/7/16.
 */

public abstract class RxBusFragment extends BaseFragment {
    public abstract void initRxBus();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRxBus();
    }
}
