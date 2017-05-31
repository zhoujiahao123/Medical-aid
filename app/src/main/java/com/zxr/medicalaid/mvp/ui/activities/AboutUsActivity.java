package com.zxr.medicalaid.mvp.ui.activities;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;

import butterknife.InjectView;

public class AboutUsActivity extends BaseActivity {


    @InjectView(R.id.about_us_web_view)
    WebView mWebView;

    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("http://nmid.cqupt.edu.cn/");
    }

    @Override
    public int getLayout() {
        return R.layout.activity_about_us;
    }


}
