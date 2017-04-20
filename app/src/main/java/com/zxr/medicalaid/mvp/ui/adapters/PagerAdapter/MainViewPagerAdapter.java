package com.zxr.medicalaid.mvp.ui.adapters.PagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 猿人 on 2017/4/20.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> itemFragments;

    public void setItemFragments(List<Fragment> itemFragments) {
        this.itemFragments = itemFragments;
    }

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return itemFragments.get(position);
    }

    @Override
    public int getCount() {
        return itemFragments.size();
    }
}
