package com.zxr.medicalaid.mvp.ui.fragments;

import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.AboutUsActivity;
import com.zxr.medicalaid.mvp.ui.activities.InquiryActivity;

import com.zxr.medicalaid.mvp.ui.activities.TreatmentRecordActivity;
import com.zxr.medicalaid.mvp.ui.fragments.base.BaseFragment;
import com.zxr.medicalaid.utils.system.ToActivityUtil;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by 猿人 on 2017/4/20.
 */

public class PersonFragment extends BaseFragment implements View.OnTouchListener {


    @InjectView(R.id.presribe_bt)
    ImageView mPresribeBt;
    @InjectView(R.id.caution_bt)
    ImageView mCautionBt;
    @InjectView(R.id.about_us_bt)
    ImageView mAboutUsBt;
    @InjectView(R.id.treat_record_bt)
    ImageView mTreatRecordBt;

    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        mPresribeBt.setOnTouchListener(this);
        mCautionBt.setOnTouchListener(this);
        mAboutUsBt.setOnTouchListener(this);
        mTreatRecordBt.setOnTouchListener(this);
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
                ToActivityUtil.toNextActivity(getContext(), TreatmentRecordActivity.class);
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    v.setForeground(getResources().getDrawable(R.drawable.image_bg,null));
                }
                break;
            case MotionEvent.ACTION_UP:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    v.setForeground(null);
                }
                Log.i(TAG,R.id.prescribe_bt+"");
                Log.i(TAG,v.getId()+"");
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,"d");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"p");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"s");
    }
}
