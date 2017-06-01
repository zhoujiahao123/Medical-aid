package com.zxr.medicalaid.mvp.ui.activities;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.github.lazylibrary.util.DensityUtil;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.entity.Person;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.mvp.ui.adapters.InquiryContentAdapter;
import com.zxr.medicalaid.mvp.ui.adapters.InquiryHeaderAdapter;
import com.zxr.medicalaid.utils.others.EasyRecyViewInitUtils;
import com.zxr.medicalaid.widget.StickyHeaderDecoration;

import butterknife.InjectView;

public class InquiryActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {


    /**
     * view
     */
    @InjectView(R.id.inquiry_easy_recycler_view)
    EasyRecyclerView mEasyRecyclerView;

    /**
     * 数据
     */
    private InquiryContentAdapter adapter ;


    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        //初始化adaper
        adapter = new InquiryContentAdapter(this);

        adapter.setOnItemClickListener((position) -> {
            //进行详细药方详细信息显示

        });
        //初始化RecyclerView
        mEasyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerDecoration itemDecoration = new DividerDecoration(Color.GRAY, DensityUtil.dip2px(this,0.5f),DensityUtil.dip2px(this,8f),DensityUtil.dip2px(this,8f));
//        itemDecoration.setDrawLastItem(false);
        mEasyRecyclerView.addItemDecoration(itemDecoration);
        mEasyRecyclerView.setAdapter(adapter);
        EasyRecyViewInitUtils.initEasyRecyclerView(mEasyRecyclerView);

        //加入header
        StickyHeaderDecoration decoration = new StickyHeaderDecoration(new InquiryHeaderAdapter(this));
        decoration.setIncludeHeader(false);
        mEasyRecyclerView.addItemDecoration(decoration);
        mEasyRecyclerView.setRefreshListener(this);
        mEasyRecyclerView.setRefreshing(true,true);

    }

    @Override
    public int getLayout() {
        return R.layout.activity_inquiry;
    }

    /**
     * 测试用的handler
     */
    private Handler handler = new Handler();
    @Override
    public void onRefresh() {
        //进行加载
        handler.postDelayed(() ->{
            adapter.add((new Person("张兴锐","ffff","fdfdafdsaf")));
            adapter.notifyDataSetChanged();
        },1000);

    }
}
