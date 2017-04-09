package com.zxr.medicalaid.mvp.ui.fragments.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zxr.medicalaid.App;
import com.zxr.medicalaid.dagger.component.DaggerFragmentComponent;
import com.zxr.medicalaid.dagger.component.FragmentComponent;
import com.zxr.medicalaid.dagger.module.FragmentModule;
import com.zxr.medicalaid.mvp.presenter.base.BasePresenter;

import butterknife.ButterKnife;

/**
 * Created by 猿人 on 2017/4/9.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    protected T mPresenter;
    protected FragmentComponent mFragmentComponent;

    public FragmentComponent getFragmentComponent() {
        return mFragmentComponent;
    }

    public abstract void initInjector();

    public abstract void initViews();

    public abstract int getLayoutId();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragmentComponent();
        initInjector();
    }

    private void initFragmentComponent() {
        mFragmentComponent = DaggerFragmentComponent.builder()
                .applicationComponent(((App) getActivity().getApplication()).getmApplicationComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        initViews();
        if (mPresenter != null) {
            mPresenter.onCreate();
        }

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
