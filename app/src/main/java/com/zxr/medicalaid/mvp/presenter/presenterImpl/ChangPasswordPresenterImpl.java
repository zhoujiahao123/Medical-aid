package com.zxr.medicalaid.mvp.presenter.presenterImpl;

import com.zxr.medicalaid.mvp.model.ModelImpl.ChangPasswordModelImpl;
import com.zxr.medicalaid.mvp.presenter.base.BasePresenterImpl;
import com.zxr.medicalaid.mvp.presenter.ChangPasswordPresenter;
import com.zxr.medicalaid.mvp.view.ChangPasswordView;
import com.zxr.medicalaid.net.FilterSubscriber;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 猿人 on 2017/7/14.
 */

public class ChangPasswordPresenterImpl extends BasePresenterImpl<ChangPasswordView> implements ChangPasswordPresenter {

    @Inject
    ChangPasswordModelImpl mchangPasswordModel;

    @Inject
    public ChangPasswordPresenterImpl() {
    }

    @Override
    public void changPassword(String id, String oldPassword, String newPassword) {
        mchangPasswordModel.changPassword(id,oldPassword,newPassword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FilterSubscriber<String>() {
                    @Override
                    public void onCompleted() {
                        mView.changSuccess();
                    }

                    @Override
                    public void onNext(String s) {
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        mView.showMsg(error);
                    }
                });
    }
}
