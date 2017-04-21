package com.zxr.medicalaid.mvp.ui.activities;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.mvp.ui.adapters.PagerAdapter.MainViewPagerAdapter;
import com.zxr.medicalaid.mvp.ui.fragments.PersonFragment;
import com.zxr.medicalaid.mvp.ui.fragments.SearchFragment;
import com.zxr.medicalaid.mvp.ui.fragments.SelectFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

public class MainViewActivity extends BaseActivity {


    @InjectView(R.id.main_title_tv)
    TextView mTitleTv;
    @InjectView(R.id.select_bt)
    ImageView mSelectBt;
    @InjectView(R.id.search_bt)
    ImageView mSearchBt;
    @InjectView(R.id.personage)
    ImageView mPersonageBt;
    @InjectView(R.id.main_view_pager)
    ViewPager mViewPager;

    /**
     * 几个常亮
     */
    private final int SELECT_FRAGMENT = 0;
    private final int SEARCH_FRAGMENT = 1;
    private final int PERSONAGE_FRAGMENT = 2;


    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        //viewpager初始化
        Fragment selectFragment = new SelectFragment();
        Fragment searchFragment = new SearchFragment();
        Fragment personFragment = new PersonFragment();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(selectFragment);
        fragments.add(searchFragment);
        fragments.add(personFragment);

        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager());
        adapter.setFragments(fragments);

        mViewPager.setAdapter(adapter);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main_view;
    }


    @OnClick({R.id.select_bt, R.id.search_bt, R.id.personage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.select_bt:
                mViewPager.setCurrentItem(SELECT_FRAGMENT);
                break;
            case R.id.search_bt:
                mViewPager.setCurrentItem(SEARCH_FRAGMENT);
                break;
            case R.id.personage:
                mViewPager.setCurrentItem(PERSONAGE_FRAGMENT);
                break;
        }
    }


}
