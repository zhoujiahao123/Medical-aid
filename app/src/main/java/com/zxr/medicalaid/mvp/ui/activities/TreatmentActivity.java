package com.zxr.medicalaid.mvp.ui.activities;

import android.support.v7.widget.Toolbar;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.utils.others.EasyRecyViewInitUtils;

import butterknife.InjectView;

public class TreatmentActivity extends BaseActivity {


    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.easy_recycler_view)
    EasyRecyclerView mRecyclerView;

    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        EasyRecyViewInitUtils.initEasyRecyclerView(mRecyclerView);
        //adapter初始化 暂时不知道后台会怎么提供数据。。。就先不写

    }

    @Override
    public int getLayout() {
        return R.layout.activity_treatment;
    }

}
