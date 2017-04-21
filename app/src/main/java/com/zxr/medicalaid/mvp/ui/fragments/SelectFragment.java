package com.zxr.medicalaid.mvp.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.MainViewActivity;
import com.zxr.medicalaid.mvp.ui.adapters.PagerAdapter.AdViewPagerAdapter;
import com.zxr.medicalaid.mvp.ui.fragments.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by 猿人 on 2017/4/11.
 */

public class SelectFragment extends BaseFragment {

    @InjectView(R.id.ad_viewpager)
    ViewPager mViewPager;
    @InjectView(R.id.prescribe_bt)
    ImageView mPrescribeBt;
    @InjectView(R.id.treat_bt)
    ImageView mTreatBt;

    @Inject
    Activity mActivity;

    private int index = 0;
    private int size = 0;
    /**
     * 常亮
     */
    private final String TAG = "SelectFragment";
    private final long INTERVAL = 1000 * 3;//3s
    private final long TOTAL_TIME = 1000 * 60 * 60;
    private TimeCountDown time;

    @Override
    public void initInjector() {
        mFragmentComponent.inject(this);
    }

    @Override
    public void initViews() {
        //初始化viewpager
        Fragment adFragment1 = new AdvertisementFragment();
        Bundle args1 = new Bundle();
        args1.putInt(AdvertisementFragment.RES_ID, R.drawable.scroll_image_1);
        adFragment1.setArguments(args1);

        Fragment adFragment2 = new AdvertisementFragment();
        Bundle args2 = new Bundle();
        args2.putInt(AdvertisementFragment.RES_ID, R.drawable.scroll_image_2);
        adFragment2.setArguments(args2);

        Fragment adFragment3 = new AdvertisementFragment();
        Bundle args3 = new Bundle();
        args3.putInt(AdvertisementFragment.RES_ID, R.drawable.scroll_image_3);
        adFragment3.setArguments(args3);

        Fragment adFragment4 = new AdvertisementFragment();
        Bundle args4 = new Bundle();
        args4.putInt(AdvertisementFragment.RES_ID, R.drawable.scroll_image_4);
        adFragment4.setArguments(args4);

        Fragment adFragment5 = new AdvertisementFragment();
        Bundle args5 = new Bundle();
        args5.putInt(AdvertisementFragment.RES_ID, R.drawable.scroll_image_5);
        adFragment5.setArguments(args5);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(adFragment1);
        fragments.add(adFragment2);
        fragments.add(adFragment3);
        fragments.add(adFragment4);
        fragments.add(adFragment5);

        size = fragments.size();

        AdViewPagerAdapter adapter = new AdViewPagerAdapter(((MainViewActivity) mActivity).getSupportFragmentManager());
        adapter.setFragments(fragments);
        mViewPager.setAdapter(adapter);

        time = new TimeCountDown(TOTAL_TIME, INTERVAL);
        time.start();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_select;
    }


    @OnClick({R.id.prescribe_bt, R.id.treat_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.prescribe_bt:
                break;
            case R.id.treat_bt:
                break;
        }
    }

    /**
     * 实现广告轮播轮
     */
    class TimeCountDown extends CountDownTimer {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public TimeCountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            Log.i(TAG,"onTick");
            mViewPager.setCurrentItem((++index) % size);
        }

        @Override
        public void onFinish() {

            Log.i(TAG,"onFinish");
        }
    }
}
