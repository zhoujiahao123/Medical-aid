package com.zxr.medicalaid.mvp.presenter.presenterImpl;

import android.widget.Toast;

import com.zxr.medicalaid.App;
import com.zxr.medicalaid.mvp.entity.moudle.CancleInfo;
import com.zxr.medicalaid.mvp.model.CancleModel;
import com.zxr.medicalaid.mvp.model.ModelImpl.CancleModelImpl;
import com.zxr.medicalaid.mvp.presenter.CanclePresenter;
import com.zxr.medicalaid.mvp.presenter.base.BasePresenterImpl;
import com.zxr.medicalaid.mvp.view.CancleView;
import com.zxr.medicalaid.utils.others.CodeUtil;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ASUS-NB on 2017/7/14.
 */

public class CanclePresenterImpl extends BasePresenterImpl<CancleView> implements CanclePresenter {
    CancleModel model = new CancleModelImpl();
    @Inject
    public CanclePresenterImpl(){

    }
    @Override
    public void cancleLink(String doctorId, String patientId) {
        model.cancleLink(doctorId, patientId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CancleInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CancleInfo cancleInfo) {
                        if(CodeUtil.codeCheck(cancleInfo.getCode()).equals("OK"))
                        mView.cancleLinkSucceed();
                        else {
                            Toast.makeText(App.getBaseApplicationContext(),CodeUtil.codeCheck(cancleInfo.getCode()),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
