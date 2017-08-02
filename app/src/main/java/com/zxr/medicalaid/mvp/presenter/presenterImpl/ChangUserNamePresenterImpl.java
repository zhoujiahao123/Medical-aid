package com.zxr.medicalaid.mvp.presenter.presenterImpl;

import com.zxr.medicalaid.mvp.model.ModelImpl.ChangUserNameModelImpl;
import com.zxr.medicalaid.mvp.presenter.ChangeUserNamePresenter;
import com.zxr.medicalaid.mvp.presenter.base.BasePresenterImpl;
import com.zxr.medicalaid.mvp.view.ChangUserNameView;
import com.zxr.medicalaid.net.FilterSubscriber;
import com.zxr.medicalaid.utils.db.DbUtil;
import com.zxr.medicalaid.utils.system.RxBus;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 猿人 on 2017/7/16.
 */

public class ChangUserNamePresenterImpl extends BasePresenterImpl<ChangUserNameView>  implements ChangeUserNamePresenter {

    @Inject
    ChangUserNameModelImpl model;

    @Inject
    public ChangUserNamePresenterImpl() {
    }

    @Override
    public void changUserName(String id, String newName) {
        model.changeUserName(id,newName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FilterSubscriber<String>() {
                    @Override
                    public void onCompleted() {
                        //刷新数据库
                        User user = DbUtil.getDaosession().getUserDao().loadAll().get(0);
                        user.setUName(newName);
                        DbUtil.getDaosession().getUserDao().update(user);
                        RxBus.getDefault().post(new String("修改昵称成功"));
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        mView.showMsg(error);
                    }

                    @Override
                    public void onNext(String s) {
                        mView.showMsg("修改成功");
                    }
                });
    }
}
