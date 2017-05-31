package com.zxr.medicalaid.mvp.ui.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
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

public class MainViewActivity extends BaseActivity {


    @InjectView(R.id.main_title_tv)
    TextView mTitleTv;
    @InjectView(R.id.main_view_pager)
    ViewPager mViewPager;
    @InjectView(R.id.navigation)
    BottomNavigationView mBottomNav;

    private String titles[] = new String[]{"主页", "药材百科", "个人中心"};

    /**
     * 几个常量
     */
    private final int SELECT_FRAGMENT = 0;
    private final int SEARCH_FRAGMENT = 1;
    private final int PERSONAGE_FRAGMENT = 2;


    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        //加入底部导航监听
        mBottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            private MenuItem prevMenuItem;
            @Override
            public void onPageSelected(int position) {
                mTitleTv.setText(titles[position]);
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    mBottomNav.getMenu().getItem(0).setChecked(false);
                }
                mBottomNav.getMenu().getItem(position).setChecked(true);
                prevMenuItem = mBottomNav.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main_view;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.select_ui:
                    mViewPager.setCurrentItem(SELECT_FRAGMENT);
                    return true;
                case R.id.search_ui:
                    mViewPager.setCurrentItem(SEARCH_FRAGMENT);
                    return true;
                case R.id.personage_ui:
                   mViewPager.setCurrentItem(PERSONAGE_FRAGMENT);
                    return true;
            }
            return false;
        }

    };

}
