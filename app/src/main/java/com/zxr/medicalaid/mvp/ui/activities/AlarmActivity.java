package com.zxr.medicalaid.mvp.ui.activities;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;

import butterknife.InjectView;

public class AlarmActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.easy_recyclerview)
    EasyRecyclerView mRecyclerView;

    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setTitle("服药提醒设置");
        mToolbar.setTitleTextColor(0xFFFFFF);
        //初始化数据
        //===============================================这里做测试
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.alarm_item,null);
        mRecyclerView.addView(view);
        mRecyclerView.addView(view);
        mRecyclerView.addView(view);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_alarm;
    }


}
