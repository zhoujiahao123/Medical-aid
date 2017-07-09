package com.zxr.medicalaid.mvp.ui.fragments;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.presenter.presenterImpl.DrugInfoPresenterImpl;
import com.zxr.medicalaid.mvp.ui.fragments.base.BaseFragment;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * Created by 猿人 on 2017/4/20.
 */

public class SearchFragment extends BaseFragment {

    @Inject
    DrugInfoPresenterImpl presenter;
    @InjectView(R.id.web_view)
    WebView mWebView;

    //    @InjectView(R.id.input_medicine)
//    EditText mSearch;
//    @InjectView(R.id.search_confirm_bt)
//    ImageView mConfirmBt;
//    @InjectView(R.id.easy_recyclerview)
//    EasyRecyclerView mRecycler;
//
//    private TextWatcher watcher = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            if(s.toString().length() == 0){
//                mConfirmBt.setVisibility(View.INVISIBLE);
//            }else{
//                mConfirmBt.setVisibility(View.VISIBLE);
//            }
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//
//        }
//    };
    @Override
    public void initInjector() {
//        mFragmentComponent.inject(this);
//        presenter.injectView(this);

    }

    @Override
    public void initViews() {
//        mSearch.addTextChangedListener(watcher);
//
//        mConfirmBt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(presenter==null){
//                    Log.e("TAG","presenter是空的");
//                }else {
//                    presenter.getDrugInfo("中文");
//                }
//            }
//        });
        WebSettings webSettings = mWebView.getSettings();
        //支持JS
        webSettings.setJavaScriptEnabled(true);
        //支持屏幕缩放
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        //不显示webview缩放按钮
        webSettings.setDisplayZoomControls(false);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("http://baike.baidu.com/item/%E5%BD%93%E5%BD%92");
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search;
    }




}
