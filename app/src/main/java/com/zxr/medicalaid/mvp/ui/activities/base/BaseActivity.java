package com.zxr.medicalaid.mvp.ui.activities.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zxr.medicalaid.App;
import com.zxr.medicalaid.dagger.component.ActivityComponent;
import com.zxr.medicalaid.dagger.component.DaggerActivityComponent;
import com.zxr.medicalaid.dagger.module.ActivityModule;
import com.zxr.medicalaid.mvp.presenter.base.BasePresenterImpl;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * Created by 猿人 on 2017/4/9.
 */

public abstract class BaseActivity<T extends BasePresenterImpl> extends AppCompatActivity {

    protected ActivityComponent mActivityComponent;
    protected T mPresenter;
    protected Subscription mSubscription;

    /**
     * 初始化注入信息
     */
    public abstract void initInjector();

    /**
     * 初始化view，相关view配置
     */
    public abstract void initViews();

    /**
     * 得到资源layout id
     */
    public abstract int getLayout();


    //===============================================
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化组件 注入器
        initActivityComponent();

        setContentView(getLayout());
        ButterKnife.inject(this);

        initInjector();

        initViews();
        //完成presenter中的初始化
        if (mPresenter != null) {
            mPresenter.onCreate();
        }

    }

    private void initActivityComponent() {
        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((App) getApplication()).getmApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mSubscription != null && mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }
}
