package com.zxr.medicalaid.mvp.ui.activities;

import android.support.v7.widget.LinearLayoutManager;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.entity.PrescriptionItem;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.mvp.ui.adapters.PrescribeTableAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

public class PrescribeDetailActivity extends BaseActivity {


    @InjectView(R.id.easy_recycler_view)
    EasyRecyclerView mRecyclerView;

    private PrescribeTableAdapter adapter;

    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        adapter = new PrescribeTableAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);

        List<PrescriptionItem> list = new ArrayList<>();
        list.add(new PrescriptionItem("人参", "3"));
        list.add(new PrescriptionItem("人参", "3"));
        list.add(new PrescriptionItem("人参", "3"));
        list.add(new PrescriptionItem("人参", "3"));
        list.add(new PrescriptionItem("人参", "3"));
        list.add(new PrescriptionItem("人参", "3"));
        adapter.addAll(list);

        findViewById(android.R.id.content).setOnClickListener(
                v -> finish()
        );

    }

    @Override
    public int getLayout() {
        return R.layout.activity_prescribe_detail;
    }


}