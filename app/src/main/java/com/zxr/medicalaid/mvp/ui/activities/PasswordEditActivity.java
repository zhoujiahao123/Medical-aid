package com.zxr.medicalaid.mvp.ui.activities;

import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;

import com.github.lazylibrary.util.ToastUtils;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by 猿人 on 2017/7/7.
 */

public class PasswordEditActivity extends BaseActivity {
    @InjectView(R.id.old_password_input)
    EditText oldPasswordInput;
    @InjectView(R.id.new_password_input)
    EditText newPasswordInput;
    @InjectView(R.id.confirm_password_input)
    EditText confirmPasswordInput;
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;


    /**
     * 设置一个标志位
     */
    private boolean oldPasswordIsRight = false;

    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbar.setTitle(R.string.reset_password);
        mToolbar.setTitleTextColor(Color.WHITE);

        oldPasswordInput.setOnFocusChangeListener(
                (v, hasFocus) -> {
                    if (!hasFocus) {
                        //当失去焦点的时候,进行网络请求，原密码是否正确
                        //如果不正确就显示错误信息
                        String oldPasswordTv;
                        //如果源密码正确就把标志位设置为正确
                        oldPasswordIsRight = true;
                    }
                }
        );
    }

    @Override
    public int getLayout() {
        return R.layout.activity_password_edit;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.finish_bt)
    public void onViewClicked() {
        if (!oldPasswordIsRight) {
            ToastUtils.showToast(this, "原密码不正确，请检查");
            return;
        }
        //检查两个新密码是否相同
        String newPassword = newPasswordInput.getText().toString();
        String newPasswordConfimr = confirmPasswordInput.getText().toString();
        if (!newPassword.equals(newPasswordConfimr)) {
            ToastUtils.showToast(this, "两次密码不相同,请检查");
            return;
        }
        //在这里进行更改密码的请求
    }


}
