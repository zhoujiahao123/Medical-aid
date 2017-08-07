package com.zxr.medicalaid.mvp.ui.activities;

import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.entity.PrescriptionItem;
import com.zxr.medicalaid.mvp.entity.moudle.DrugDose;
import com.zxr.medicalaid.mvp.entity.moudle.PrescriptionInfo;
import com.zxr.medicalaid.mvp.presenter.presenterImpl.GetPrescriptionPresenterImpl;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.mvp.ui.adapters.PrescribeTableAdapter;
import com.zxr.medicalaid.mvp.view.GetPrescriptionView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;

public class PrescribeRecordActivity extends BaseActivity implements GetPrescriptionView{


    @InjectView(R.id.easy_recycler_view)
    EasyRecyclerView mRecyclerView;

    private PrescribeTableAdapter adapter;
    @Inject
    GetPrescriptionPresenterImpl presenter;
    @Override
    public void initInjector() {
        presenter.injectView(this);
        mActivityComponent.inject(this);
    }

    @Override
    public void initViews() {
        adapter = new PrescribeTableAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
        String linkId = getIntent().getStringExtra("linkId");
        presenter.getPrescription(Long.valueOf(linkId));

        findViewById(android.R.id.content).setOnClickListener(
                v -> finish()
        );

    }

    @Override
    public int getLayout() {
        return R.layout.activity_prescribe_detail;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void getSucceed(PrescriptionInfo info) {
        List<DrugDose> drugDoses = new ArrayList<>();
        drugDoses = info.getBody().getDrugs();
        List<PrescriptionItem> list = new ArrayList<>();
        for(int i=0;i<drugDoses.size();i++){
            list.add(new PrescriptionItem(drugDoses.get(i).getDrugName(),drugDoses.get(i).getDose()));
        }
        adapter.addAll(list);
    }
}
