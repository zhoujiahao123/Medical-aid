package com.zxr.medicalaid.mvp.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.LinearInterpolator;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.dagger.scope.ContextLife;
import com.zxr.medicalaid.mvp.entity.Person;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.mvp.ui.adapters.PatientListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * 区分药师和病人
 */
public class PrescribeActivity extends BaseActivity {


    @InjectView(R.id.mToolbar)
    Toolbar mToolbar;
    @InjectView(R.id.person_list)
    EasyRecyclerView mRecycler;

    public static final String GET_FROM = "get_from";
    private int type = 0;
    public static final int DOCTOR = 1;
    public static final int PATIENT = 2;

    /**
     * adapter
     */
    private PatientListAdapter adapter;
    /**
     * context
     */

    @Inject
    @ContextLife("Activity")
    Context mContext;

    //===============================================测试
    private List<Person> lists = new ArrayList<>();

    @Override
    public void initInjector() {
        mActivityComponent.inject(this);
    }

    @Override
    public void initViews() {
        //toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //recyclerview
        adapter = new PatientListAdapter(this);
        //===============================================测试
        for (int i = 0; i < 10; i++) {
            Person person = new Person("张兴锐", "13:19", "120.77.87.78:8080/arti-sports/image//user15.png");
            lists.add(person);
        }
        adapter.addAll(lists);
        mRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setAdapter(adapter);

        //设置动画
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_patient_list_item));
        set.setInterpolator(new DecelerateInterpolator());
        LayoutAnimationController lc = new LayoutAnimationController(set);
        lc.setInterpolator(new LinearInterpolator());
        lc.setOrder(LayoutAnimationController.ORDER_NORMAL);
        lc.setDelay(0.4f);
        mRecycler.getRecyclerView().setLayoutAnimation(lc);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        //add top-left icon click event deal
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_prescribe;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        type = getIntent().getIntExtra(GET_FROM, 0);
        super.onCreate(savedInstanceState);
    }


}
