package com.zxr.medicalaid.mvp.ui.adapters.PagerAdapter.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 猿人 on 2017/4/21.
 */

public class BaseViewPagerAdapter extends FragmentPagerAdapter {
    protected List<Fragment> fragments = new ArrayList<>();

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    public BaseViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
