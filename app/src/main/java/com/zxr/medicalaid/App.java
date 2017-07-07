package com.zxr.medicalaid;

import android.app.Application;

import com.zxr.medicalaid.dagger.component.ApplicationComponent;
import com.zxr.medicalaid.dagger.component.DaggerApplicationComponent;
import com.zxr.medicalaid.dagger.module.ApplicationModule;
import com.zxr.medicalaid.utils.image.GlideImageLoader;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.ThemeConfig;

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
        initGallerFinal();
    }

    private void initGallerFinal() {
        //设置主题
        //ThemeConfig.CYAN
        //配置功能
        FunctionConfig functionConfig = new FunctionConfig.Builder()
                .setEnableCamera(false)
                .setEnableEdit(true)
                .setEnableCrop(true)
                .setEnableRotate(true)
                .setCropSquare(true)
                .setEnablePreview(true)
                .build();
        //配置imageloader
        ImageLoader imageloader = new GlideImageLoader();
        CoreConfig coreConfig = new CoreConfig.Builder(this, imageloader, ThemeConfig.DARK)
                .setDebug(BuildConfig.DEBUG)
                .setFunctionConfig(functionConfig)
                .build();
        GalleryFinal.init(coreConfig);
    }

    private void initApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }
}
