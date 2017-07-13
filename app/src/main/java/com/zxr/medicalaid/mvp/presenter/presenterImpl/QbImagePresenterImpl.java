package com.zxr.medicalaid.mvp.presenter.presenterImpl;

import com.zxr.medicalaid.mvp.model.ModelImpl.QbImageModelImpl;
import com.zxr.medicalaid.mvp.model.QbImageModel;
import com.zxr.medicalaid.mvp.presenter.base.BasePresenterImpl;
import com.zxr.medicalaid.mvp.presenter.QbImagePresenter;
import com.zxr.medicalaid.mvp.view.QbImageView;
import com.zxr.medicalaid.net.FilterSubscriber;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 猿人 on 2017/7/13.
 */

public class QbImagePresenterImpl extends BasePresenterImpl<QbImageView> implements QbImagePresenter {

    QbImageModel qbModel = new QbImageModelImpl();


    @Override
    public void showQbImage(String id) {
        mView.showProgress();
        qbModel.getQBImage(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FilterSubscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                        mView.hideProgress();
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {

                    }
                });
    }
}
