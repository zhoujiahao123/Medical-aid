package com.zxr.medicalaid.mvp.ui.activities.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import rx.Subscription;

/**
 * Created by 猿人 on 2017/5/24.
 */

public abstract class RxBusSubscriberBaseActivity extends BaseActivity {

    /**
     * 进行RxBus的订阅
     */
    public abstract void initRxBus();
    protected Subscription mSubscription;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRxBus();
    }

    @Override
    protected void onDestroy() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
        super.onDestroy();
    }
}
