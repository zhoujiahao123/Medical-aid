package com.zxr.medicalaid.mvp.ui.fragments;

import android.app.AlertDialog;
import android.content.Intent;
import android.provider.AlarmClock;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.TextView;

import com.zxr.medicalaid.DaoSession;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.User;
import com.zxr.medicalaid.UserDao;
import com.zxr.medicalaid.mvp.ui.activities.AboutUsActivity;
import com.zxr.medicalaid.mvp.ui.activities.InquiryActivity;
import com.zxr.medicalaid.mvp.ui.activities.QbShowActivity;
import com.zxr.medicalaid.mvp.ui.activities.TreatmentRecordActivity;
import com.zxr.medicalaid.mvp.ui.activities.UserInfoEditActivity;
import com.zxr.medicalaid.mvp.ui.fragments.base.BaseFragment;
import com.zxr.medicalaid.utils.db.DbUtil;
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
    @InjectView(R.id.user_info_layout)
    ConstraintLayout userInfoLayout;

    DaoSession daoSession = DbUtil.getDaosession();
    UserDao userDao = daoSession.getUserDao();

    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        User user = userDao.queryBuilder().where(UserDao.Properties.IsAlready.eq(1)).unique();
        userName.setText(user.getUName());
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


    @OnClick({R.id.presribe_bt, R.id.about_us_bt, R.id.caution_bt, R.id.treat_record_bt, R.id.generate_qb})
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
            case R.id.generate_qb:
                //可能有bug
                String type = DbUtil.getDaosession().getUserDao().loadAll().get(0).getType();
                if (type.equals("doctor")) {
                    String id = DbUtil.getDaosession().getUserDao().loadAll().get(0).getIdString();
                    Intent intent = new Intent(getContext(), QbShowActivity.class);
                    intent.putExtra("doctorId", id);
                    getContext().startActivity(intent);
                } else {
                    new AlertDialog.Builder(getContext())
                            .setTitle("提示")
                            .setMessage("只有医生才能生成二维码哦")
                            .setPositiveButton("我知道了",
                                    (dialog, what) -> {
                                        dialog.dismiss();
                                    })
                            .setCancelable(true)
                            .show();
                }
                break;

        }
    }


}


