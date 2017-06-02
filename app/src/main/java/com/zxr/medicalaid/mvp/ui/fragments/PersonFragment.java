package com.zxr.medicalaid.mvp.ui.fragments;

import android.view.View;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.AboutUsActivity;
import com.zxr.medicalaid.mvp.ui.activities.InquiryActivity;
import com.zxr.medicalaid.mvp.ui.activities.TreatmentActivity;
import com.zxr.medicalaid.mvp.ui.fragments.base.BaseFragment;
import com.zxr.medicalaid.utils.system.ToActivityUtil;

import butterknife.OnClick;

/**
 * Created by 猿人 on 2017/4/20.
 */

public class PersonFragment extends BaseFragment {


    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_personage;
    }


    @OnClick({R.id.presribe_bt, R.id.about_us_bt, R.id.caution_bt, R.id.treat_record_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.presribe_bt:
                ToActivityUtil.toNextActivity(getContext(), InquiryActivity.class);
                break;
            case R.id.about_us_bt:
                ToActivityUtil.toNextActivity(getContext(), AboutUsActivity.class);
                break;
            case R.id.caution_bt:
                break;
            case R.id.treat_record_bt:
                ToActivityUtil.toNextActivity(getContext(), TreatmentActivity.class);
                break;
        }
    }
}
