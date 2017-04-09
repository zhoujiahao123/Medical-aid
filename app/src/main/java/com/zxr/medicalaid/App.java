package com.zxr.medicalaid;

import android.app.Application;

import com.zxr.medicalaid.dagger.component.ApplicationComponent;
import com.zxr.medicalaid.dagger.component.DaggerApplicationComponent;
import com.zxr.medicalaid.dagger.module.ApplicationModule;

/**
 * Created by 猿人 on 2017/4/9.
 */

public class App extends Application {

    private ApplicationComponent mApplicationComponent;

    public ApplicationComponent getmApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationComponent();
    }
    private void initApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }
}
