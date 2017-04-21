package com.zxr.medicalaid.mvp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.fragments.base.BaseFragment;

import butterknife.InjectView;

/**
 * Created by 猿人 on 2017/4/21.
 */

public class AdvertisementFragment extends BaseFragment {
    private final String TAG = "AdFragment";
    @InjectView(R.id.ad_image_view)
    ImageView mIm;
    /**
     * 常亮
     */
    public static final String RES_ID = "res_id";

    private int resId;

    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        mIm.setImageResource(resId);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_advertisement;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            resId  = getArguments().getInt(RES_ID);
        }
    }

}
