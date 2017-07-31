package com.zxr.medicalaid.mvp.ui.activities.base;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zxr.medicalaid.App;
import com.zxr.medicalaid.dagger.component.ActivityComponent;
import com.zxr.medicalaid.dagger.component.DaggerActivityComponent;
import com.zxr.medicalaid.dagger.module.ActivityModule;
import com.zxr.medicalaid.utils.system.ActivityStack;

import butterknife.ButterKnife;

/**
 * Created by 猿人 on 2017/4/9.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected ActivityComponent mActivityComponent;

    protected String TAG;

    ConnectivityManager manager;
    NetworkInfo networkInfo;
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

        TAG = this.getClass().getSimpleName();

        ActivityStack.getScreenManager().pushActivity(this);
        //初始化组件 注入器
        initActivityComponent();

        setContentView(getLayout());
        ButterKnife.inject(this);

        initInjector();
        initViews();


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
        ActivityStack.getScreenManager().popActivity(this);
    }
    public boolean isNetWork(){
        manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        networkInfo = manager.getActiveNetworkInfo();
        if(networkInfo!=null&&networkInfo.isAvailable()){
            return true;
        }else {
            return false;
        }
    }
}
