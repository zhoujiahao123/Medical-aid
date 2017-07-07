package com.zxr.medicalaid.mvp.ui.activities;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.github.lazylibrary.util.DensityUtil;
import com.github.lazylibrary.util.ToastUtils;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.entity.Person;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.mvp.ui.adapters.InquiryContentAdapter;
import com.zxr.medicalaid.mvp.ui.adapters.InquiryHeaderAdapter;
import com.zxr.medicalaid.utils.others.EasyRecyViewInitUtils;
import com.zxr.medicalaid.widget.StickyHeaderDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

public class InquiryActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {


    /**
     * view
     */
    @InjectView(R.id.inquiry_easy_recycler_view)
    EasyRecyclerView mEasyRecyclerView;
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    /**
     * 数据
     */
    private InquiryContentAdapter adapter;


    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        //初始化ActionBar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setTitle(R.string.inquiryRecord);
        mToolbar.setTitleTextColor(Color.WHITE);
        //初始化adaper
        adapter = new InquiryContentAdapter(this);

        adapter.setOnItemClickListener((position) -> {
            //进行详细药方详细信息显示
            ToastUtils.showToast(this, position + "");
        });
        //初始化RecyclerView
        mEasyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerDecoration itemDecoration = new DividerDecoration(Color.GRAY, DensityUtil.dip2px(this, 0.5f), DensityUtil.dip2px(this, 8f), DensityUtil.dip2px(this, 8f));
        itemDecoration.setDrawLastItem(false);
        mEasyRecyclerView.addItemDecoration(itemDecoration);
        mEasyRecyclerView.setAdapter(adapter);
        EasyRecyViewInitUtils.initEasyRecyclerView(mEasyRecyclerView);

        //加入header
        StickyHeaderDecoration decoration = new StickyHeaderDecoration(new InquiryHeaderAdapter(this, adapter));
        decoration.setIncludeHeader(true);
        mEasyRecyclerView.addItemDecoration(decoration);
        mEasyRecyclerView.setRefreshListener(this);
        mEasyRecyclerView.setRefreshing(true, true);

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
        return R.layout.activity_inquiry;
    }

    /**
     * 测试用的handler
     */
    private Handler handler = new Handler();
    private List<Person> datas = new ArrayList<>();

    @Override
    public void onRefresh() {
        //进行加载
        handler.postDelayed(() -> {
            Person person1 = new Person("111", "2017-02-22", "111");
            Person person2 = new Person("111", "2017-02-22", "111");
            Person person3 = new Person("111", "2017-02-23", "111");
            Person person4 = new Person("111", "2017-02-23", "111");
            Person person5 = new Person("111", "2017-02-24", "111");
            Person person6 = new Person("111", "2017-02-24", "111");
            Person person7 = new Person("111", "2017-02-25", "111");
            Person person8 = new Person("111", "2017-02-25", "111");
            Person person9 = new Person("111", "2017-02-28", "111");
            datas.add(person1);
            datas.add(person2);
            datas.add(person3);
            datas.add(person4);
            datas.add(person5);
            datas.add(person6);
            datas.add(person7);
            datas.add(person8);
            datas.add(person9);

            adapter.addAll(datas);
        }, 1000);

    }


}
