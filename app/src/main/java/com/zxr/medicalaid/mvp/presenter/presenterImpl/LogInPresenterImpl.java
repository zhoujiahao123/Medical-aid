package com.zxr.medicalaid.mvp.presenter.presenterImpl;

import com.zxr.medicalaid.mvp.entity.moudle.UserInfo;
import com.zxr.medicalaid.mvp.model.LogInModel;
import com.zxr.medicalaid.mvp.model.ModelImpl.LogInModelImpl;
import com.zxr.medicalaid.mvp.presenter.LogInPresenter;
import com.zxr.medicalaid.mvp.presenter.base.BasePresenterImpl;
import com.zxr.medicalaid.mvp.view.LogInView;
import com.zxr.medicalaid.net.FilterSubscriber;
import com.zxr.medicalaid.utils.db.DbUtil;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ASUS-NB on 2017/7/7.
 */

public class LogInPresenterImpl extends BasePresenterImpl<LogInView> implements LogInPresenter {
    LogInModel model = new LogInModelImpl();

    @Inject
    public LogInPresenterImpl() {

    }

    @Override
    public void logIn(String nickName, String password) {
        model.logIn(nickName, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FilterSubscriber<UserInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        mView.showMsg(error);
                    }

                    @Override
                    public void onNext(UserInfo userInfo) {
                        DaoSession daoSession = DbUtil.getDaosession();
                        UserDao userDao = daoSession.getUserDao();
                        User user = new User();
                        user.setType(userInfo.getType());
                        user.setUName(userInfo.getNickName());
                        user.setPhoneNumber(userInfo.getPhoneNumber());
                        user.setIdString(userInfo.getIdString());
                        user.setIsAlready(1);
                        userDao.insert(user);

                        mView.loginSuccess();
                    }
                });

    }
}
