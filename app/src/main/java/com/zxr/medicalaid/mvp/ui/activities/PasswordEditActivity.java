package com.zxr.medicalaid.mvp.ui.activities;

import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;

import com.github.lazylibrary.util.ToastUtils;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.presenter.presenterImpl.ChangPasswordPresenterImpl;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.mvp.view.ChangPasswordView;
import com.zxr.medicalaid.net.ResponseCons;
import com.zxr.medicalaid.utils.db.DbUtil;
import com.zxr.medicalaid.utils.encode.EncodeUtil;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by 猿人 on 2017/7/7.
 */

public class PasswordEditActivity extends BaseActivity implements ChangPasswordView {
    @InjectView(R.id.old_password_input)
    EditText oldPasswordInput;
    @InjectView(R.id.new_password_input)
    EditText newPasswordInput;
    @InjectView(R.id.confirm_password_input)
    EditText confirmPasswordInput;
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;


    @Inject
    ChangPasswordPresenterImpl mPresenter;


    @Override
    public void initInjector() {
        mActivityComponent.inject(this);
        mPresenter.injectView(this);
    }

    @Override
    public void initViews() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbar.setTitle(R.string.reset_password);
        mToolbar.setTitleTextColor(Color.WHITE);

        oldPasswordInput.requestFocus();
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
        //检查两个新密码是否相同
        String oldPassowrd = oldPasswordInput.getText().toString();
        String newPassword = newPasswordInput.getText().toString();
        String newPasswordConfirm = confirmPasswordInput.getText().toString();
        if (!newPasswordConfirm.equals(newPassword)){
            ToastUtils.showToast(this,"两次密码不一致");
            return;
        }
        String idString = DbUtil.getDaosession().getUserDao().loadAll().get(0).getIdString();
        mPresenter.changPassword(idString, EncodeUtil.doEncrypt(oldPassowrd, ResponseCons.KEY_PASSWORD),EncodeUtil.doEncrypt(newPassword,ResponseCons.KEY_PASSWORD));
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMsg(String msg) {
        ToastUtils.showToast(this,msg);
    }

    @Override
    public void changSuccess() {
        ToastUtils.showToast(this,"修改成功");
        finish();
    }
}
