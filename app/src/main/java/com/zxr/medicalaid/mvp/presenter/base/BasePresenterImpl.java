package com.zxr.medicalaid.mvp.presenter.base;

import android.support.annotation.NonNull;

import com.zxr.medicalaid.listener.RequestCallBack;
import com.zxr.medicalaid.mvp.view.base.BaseView;

/**
 * Created by 猿人 on 2017/4/9.
 */

/**
 *
 * @param <T> view
 * @param <E> 数据
 */
public class BasePresenterImpl<T extends BaseView,E> implements BasePresenter,RequestCallBack<E> {

    //声明为protected 供子类使用
    protected T mView;

    /**
     * 进行一些初始化工作，如model的注入
     */
    @Override
    public void onCreate() {

    }
    /**
     * 注入view
     * @param view
     */
    @Override
    public void injectView(@NonNull BaseView view) {
        mView = (T) view;
    }

    @Override
    public void onSuccess(E data) {
        mView.hideProgress();
    }

    @Override
    public void onError(String errorMsg) {
        mView.hideProgress();
        mView.showError();
    }
}
