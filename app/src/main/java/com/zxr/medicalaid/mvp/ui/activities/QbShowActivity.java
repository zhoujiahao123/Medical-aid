package com.zxr.medicalaid.mvp.ui.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.github.lazylibrary.util.ToastUtils;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.presenter.presenterImpl.QbImagePresenterImpl;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.mvp.view.QbImageView;

import java.io.File;
import java.io.FileNotFoundException;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.OnClick;
import cn.finalteam.toolsfinal.BitmapUtils;

public class QbShowActivity extends BaseActivity implements QbImageView {

    @Inject
    QbImagePresenterImpl mPresenter;

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.qb_image)
    ImageView qbImage;
    @InjectView(R.id.progress_bar)
    ProgressBar progressBar;

    private Bitmap mBitmap;

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
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setTitle("二维码");

        String id = getIntent().getStringExtra("doctorId");
        if (id == null){
            ToastUtils.showToast(this,"出错了");
            finish();
        }
        mPresenter.showQbImage(id);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_qb_show;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showMsg(String msg) {
        ToastUtils.showToast(this, msg);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showQB(Bitmap bitmap) {
        mBitmap = bitmap;
        qbImage.setImageBitmap(bitmap);
    }

    @OnClick(R.id.outport_qb_image)
    public void onViewClicked() {
        if(mBitmap == null){
            ToastUtils.showToast(this,"当前尚未能成功加载，请稍候重试");
            return;
        }
        saveBitmap();
        ToastUtils.showToast(this,"保存成功");
    }
    private void saveBitmap(){
        // 首先保存图片
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsoluteFile();
        //小米手机必须这样获得public绝对路径
        String filesName = "MedicalAid图片";
        File appDir = new File(file, filesName);
        if (!appDir.exists()) {
            appDir.mkdirs();
        }
        String pic = System.currentTimeMillis()+".jpg";
        File picFile = new File(appDir,pic);
        BitmapUtils.saveBitmap(mBitmap,picFile);
        //把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(getContentResolver(),
                    picFile.getAbsolutePath(), pic, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                Uri.fromFile(new File(picFile.getPath()))));
    }

}
