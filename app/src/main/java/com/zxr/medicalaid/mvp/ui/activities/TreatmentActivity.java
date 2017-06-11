package com.zxr.medicalaid.mvp.ui.activities;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.entity.TreatmentRecordItem;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.mvp.ui.adapters.TreatmentRecordAdapter;
import com.zxr.medicalaid.utils.others.EasyRecyViewInitUtils;
import com.zxr.medicalaid.utils.system.ToActivityUtil;

import butterknife.InjectView;

public class TreatmentActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    /**
     * view
     */
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.easy_recycler_view)
    EasyRecyclerView mRecyclerView;

    /**
     * 数据
     */
    private TreatmentRecordAdapter adapter;
    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        //初始化toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbar.setTitle("就诊记录");
        mToolbar.setTitleTextColor(Color.WHITE);
        //adapter初始化 暂时不知道后台会怎么提供数据。。。就先不写
        adapter = new TreatmentRecordAdapter(this);
        adapter.setOnItemClickListener(
                position -> {
                    //传递该条药方数据到
                    ToActivityUtil.toNextActivity(this, PrescribeDetailActivity.class);
                }
        );
        //easyrecyclerview初始化
        EasyRecyViewInitUtils.initEasyRecyclerView(mRecyclerView);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setRefreshListener(this);
        mRecyclerView.setRefreshing(true, true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_treatment;
    }

    /**
     * 测试用handler
     */
    private Handler handler = new Handler();

    @Override
    public void onRefresh() {
        Log.i(TAG, "回调");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.add(new TreatmentRecordItem("2015-11-2", "当归任岑八角"));
                adapter.add(new TreatmentRecordItem("2015-11-2", "当归任岑八角"));
                adapter.add(new TreatmentRecordItem("2015-11-2", "当归任岑八角"));
                adapter.add(new TreatmentRecordItem("2015-11-2", "当归任岑八角"));
                adapter.notifyDataSetChanged();
            }
        }, 1000);
    }
}
