package com.zxr.medicalaid.mvp.ui.fragments;

import android.app.AlertDialog;
import android.content.Intent;
import android.provider.AlarmClock;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.TextView;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.AboutUsActivity;
import com.zxr.medicalaid.mvp.ui.activities.InquiryActivity;
import com.zxr.medicalaid.mvp.ui.activities.TreatmentRecordActivity;
import com.zxr.medicalaid.mvp.ui.activities.UserInfoEditActivity;
import com.zxr.medicalaid.mvp.ui.fragments.base.BaseFragment;
import com.zxr.medicalaid.utils.system.ToActivityUtil;
import com.zxr.medicalaid.widget.CircleImageView;
import com.zxr.medicalaid.widget.MaskableImageView;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by 猿人 on 2017/4/20.
 */

public class PersonFragment extends BaseFragment {


    private static final int REQUEST_CODE_GALLERY = 1;
    @InjectView(R.id.presribe_bt)
    MaskableImageView mPresribeBt;
    @InjectView(R.id.caution_bt)
    MaskableImageView mCautionBt;
    @InjectView(R.id.about_us_bt)
    MaskableImageView mAboutUsBt;
    @InjectView(R.id.treat_record_bt)
    MaskableImageView mTreatRecordBt;
    @InjectView(R.id.user_image)
    CircleImageView userImage;
    @InjectView(R.id.user_name)
    TextView userName;
    @InjectView(R.id.user_sex)
    TextView userSex;
    @InjectView(R.id.user_info_layout)
    ConstraintLayout userInfoLayout;
    @InjectView(R.id.time_wenzhen)
    TextView whenZhenNum;
    @InjectView(R.id.time_jiuzhen)
    TextView jiuZhenNum;
    @InjectView(R.id.page_num)
    TextView pageNum;


    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        //长按可编辑用户信息
        userInfoLayout.setOnLongClickListener(
                (v -> {
                    //进行弹窗显示
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle(R.string.remind)
                            .setMessage(R.string.need_to_go_to_user_setting)
                            .setCancelable(true)
                            .setPositiveButton("确定",
                                    (dialog, what) -> {
                                        ToActivityUtil.toNextActivity(getContext(), UserInfoEditActivity.class);
                                        dialog.dismiss();
                                    })
                            .setNegativeButton("取消",
                                    (dialog, what) -> dialog.dismiss()
                            )
                            .show();
                    return false;
                })
        );
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


}


