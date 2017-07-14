package com.zxr.medicalaid.mvp.presenter.presenterImpl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.zxr.medicalaid.mvp.model.ModelImpl.QbImageModelImpl;
import com.zxr.medicalaid.mvp.presenter.QbImagePresenter;
import com.zxr.medicalaid.mvp.presenter.base.BasePresenterImpl;
import com.zxr.medicalaid.mvp.view.QbImageView;
import com.zxr.medicalaid.net.FilterSubscriber;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 猿人 on 2017/7/13.
 */

public class QbImagePresenterImpl extends BasePresenterImpl<QbImageView> implements QbImagePresenter {

    @Inject
    QbImageModelImpl qbModel;

    @Inject
    public QbImagePresenterImpl() {
    }

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
                        Bitmap bitmap = BitmapFactory.decodeStream(responseBody.byteStream());
                        mView.showQB(bitmap);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        mView.showMsg(error);
                    }
                });
    }
}
