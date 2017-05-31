package com.zxr.medicalaid.mvp.ui.fragments;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.ui.fragments.base.BaseFragment;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by 猿人 on 2017/4/20.
 */

public class SearchFragment extends BaseFragment {

    @InjectView(R.id.input_medicine)
    EditText mSearch;
    @InjectView(R.id.search_confirm_bt)
    ImageView mConfirmBt;
    @InjectView(R.id.easy_recyclerview)
    EasyRecyclerView mRecycler;

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(s.toString().length() == 0){
                mConfirmBt.setVisibility(View.INVISIBLE);
            }else{
                mConfirmBt.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        mSearch.addTextChangedListener(watcher);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search;
    }


    @OnClick(R.id.search_confirm_bt)
    public void onViewClicked() {
    }
}
