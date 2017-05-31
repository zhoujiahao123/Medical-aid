package com.zxr.medicalaid.mvp.ui.activities;

import android.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.widget.CircleImageView;

import butterknife.InjectView;

public class PrescribeActivity extends BaseActivity {


    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.patient_image)
    CircleImageView mPatientImage;
    @InjectView(R.id.patient_name)
    TextView mName;
    @InjectView(R.id.patient_sex)
    TextView mSex;
    @InjectView(R.id.patient_age)
    TextView mAge;
    @InjectView(R.id.time)
    TextView mRegisterTime;

    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        //设置toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.prescibe_text);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        getMenuInflater().inflate(R.menu.precribe_confirm,menu);
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        //add top-left icon click event deal
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.confirm_bt:
                //弹窗
                AlertDialog.Builder builder = new AlertDialog.Builder(PrescribeActivity.this);
                AlertDialog dialog1 = null;
                builder.setTitle("提醒");
                builder.setMessage("您确定要进行提交吗?");
                builder.setPositiveButton("确定",
                        (dialog,which) ->
                      //进行相关逻辑
                      dialog.dismiss()
                );
                builder.setNegativeButton("取消",
                        (dialog,which) ->
                           dialog.dismiss()
                        );
                dialog1 = builder.create();
                dialog1.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_prescribe;
    }



}
