package com.zxr.medicalaid.mvp.ui.fragments;

import android.content.Intent;
import android.provider.AlarmClock;
import android.view.View;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.AboutUsActivity;
import com.zxr.medicalaid.mvp.ui.activities.InquiryActivity;
import com.zxr.medicalaid.mvp.ui.activities.TreatmentRecordActivity;
import com.zxr.medicalaid.mvp.ui.fragments.base.BaseFragment;
import com.zxr.medicalaid.utils.system.ToActivityUtil;
import com.zxr.medicalaid.widget.MaskableImageView;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by 猿人 on 2017/4/20.
 */

public class PersonFragment extends BaseFragment  {


    @InjectView(R.id.presribe_bt)
    MaskableImageView mPresribeBt;
    @InjectView(R.id.caution_bt)
    MaskableImageView mCautionBt;
    @InjectView(R.id.about_us_bt)
    MaskableImageView mAboutUsBt;
    @InjectView(R.id.treat_record_bt)
    MaskableImageView mTreatRecordBt;

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
                //跳转到系统的闹钟
                Intent alarm = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
                startActivity(alarm);
                break;
            case R.id.treat_record_bt:
                ToActivityUtil.toNextActivity(getContext(), TreatmentRecordActivity.class);
                break;
        }
    }

//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    v.setForeground(getResources().getDrawable(R.drawable.image_bg,null));
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    v.setForeground(null);
//                }
//                Log.i(TAG,R.id.prescribe_bt+"");
//                Log.i(TAG,v.getId()+"");
//                break;
//            default:
//                break;
//        }
//        return false;
//    }

}
