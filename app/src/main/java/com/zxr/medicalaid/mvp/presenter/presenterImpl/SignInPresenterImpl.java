package com.zxr.medicalaid.mvp.presenter.presenterImpl;

import android.util.Log;

import com.zxr.medicalaid.mvp.model.ModelImpl.SignInModelImpl;
import com.zxr.medicalaid.mvp.model.SignInModel;
import com.zxr.medicalaid.mvp.presenter.SignInPresenter;
import com.zxr.medicalaid.mvp.presenter.base.BasePresenterImpl;
import com.zxr.medicalaid.mvp.view.SignInView;
import com.zxr.medicalaid.net.FilterSubscriber;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ASUS-NB on 2017/7/7.
 */

public class SignInPresenterImpl extends BasePresenterImpl<SignInView> implements SignInPresenter{
    SignInModel model = new SignInModelImpl();
    @Inject
    public SignInPresenterImpl(){

    }
    @Override
    public void signIn(String nickName, String password, String phoneNumber, String type) {
        model.signIn(nickName,password,phoneNumber,type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FilterSubscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onNext(String s) {
                        mView.showMsg("OK");

                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        Log.e("TAG",error);
                        mView.showMsg(error);
                    }
                });

    }
}
