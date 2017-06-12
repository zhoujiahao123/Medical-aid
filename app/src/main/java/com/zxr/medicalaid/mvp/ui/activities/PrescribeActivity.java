package com.zxr.medicalaid.mvp.ui.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.github.lazylibrary.util.ToastUtils;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.entity.PrescriptionItem;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.mvp.ui.adapters.PrescribeTableAdapter;
import com.zxr.medicalaid.utils.others.DialogUtils;
import com.zxr.medicalaid.widget.CircleImageView;

import butterknife.InjectView;
import butterknife.OnClick;

public class PrescribeActivity extends BaseActivity {

    /**
     * view
     */
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
    @InjectView(R.id.prescribe_table)
    EasyRecyclerView mTable;
    @InjectView(R.id.medicine_name_input)
    EditText mNameInput;
    @InjectView(R.id.medicine_weight_input)
    EditText mWeightInput;


    /**
     * 数据
     */
    private PrescribeTableAdapter adapter;


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

        //设置recyclerView
        mTable.setEmptyView(R.layout.view_empty);
        mTable.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PrescribeTableAdapter(this);
        adapter.setOnItemLongClickListener(
                position -> {
                    DialogUtils.showAlert(this, "提示", "确定删除当前条目?", "确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            adapter.remove(position);
                            dialog.dismiss();
                        }
                    }, "取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    return false;
                }

        );
        mTable.setAdapter(adapter);
        //设置重量输入框的弹起类型
        mWeightInput.setRawInputType(InputType.TYPE_CLASS_NUMBER);
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        getMenuInflater().inflate(R.menu.precribe_confirm, menu);
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
                new AlertDialog.Builder(PrescribeActivity.this)
                        .setTitle("提醒")
                        .setMessage("您确定要进行提交吗?")
                        .setPositiveButton("确定",
                                (dialog, which) ->{
                                    //进行相关逻辑
                                    dialog.dismiss();
                                    finish();
                                    }
                        )
                        .setNegativeButton("取消",
                                (dialog, which) ->
                                        dialog.dismiss()
                        )
                        .show();

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_prescribe;
    }


    @OnClick(R.id.add)
    public void onViewClicked() {
        /**
         * 注意考虑药名输入加入模糊联想
         */
        String name = mNameInput.getText().toString().trim();
        String weight = mWeightInput.getText().toString().trim();

        if (name.length() == 0 || weight.length() == 0) {
            ToastUtils.showToast(this, "您的输入不完整，请重新输入");
            return;
        }
        if (getDotNumber(weight) >= 2) {
            ToastUtils.showToast(this, "小数点过多");
            return;
        }
        if (weight.charAt(0) == '.') {
            weight = '0' + weight;
        }
        if (weight.charAt(weight.length() - 1) == '.') {
            weight = weight + '0';
        }
        adapter.add(new PrescriptionItem(name, weight));
        adapter.notifyDataSetChanged();
        mNameInput.setText("");
        mWeightInput.setText("");
    }

    private int getDotNumber(String str) {
        int x = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                x++;
            }
        }
        return x;
    }
}
