package com.zxr.medicalaid.mvp.presenter.presenterImpl;

import com.zxr.medicalaid.DaoSession;
import com.zxr.medicalaid.User;
import com.zxr.medicalaid.UserDao;
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

public class LogInPresenterImpl extends BasePresenterImpl<LogInView> implements LogInPresenter{
    LogInModel model = new LogInModelImpl();
    @Inject
    public LogInPresenterImpl(){

    }
    @Override
    public void logIn(String nickName, String password) {
        model.logIn(nickName,password)
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
//        OkHttpClient client =new OkHttpClient();
//        Log.e("数据",nickName);
//        Log.e("数据",password);
//        RequestBody body  = new FormBody.Builder()
//                .add("phoneNumber",nickName)
//                .add("password",password)
//                .build();
//        Request request = new Request.Builder().url("http://120.77.87.78:8080/igds/app/user/signIn").post(body).build();
//        Call call = client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("TAG","失败"+e.getMessage());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Gson gson = new Gson();
//                String content = response.body().string();
//                UserInfo userInfo = gson.fromJson(content,UserInfo.class);
//                Log.e("数据",userInfo.getBody().getPhoneNumber());
//            }
//        });
    }
}
