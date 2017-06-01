package com.zxr.medicalaid.utils.others;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.zxr.medicalaid.R;

/**
 * Created by 猿人 on 2017/6/1.
 */

public class EasyRecyViewInitUtils {
    public static void initEasyRecyclerView(EasyRecyclerView easyRecyclerView){
        easyRecyclerView.setEmptyView(R.layout.view_empty);
        easyRecyclerView.setErrorView(R.layout.view_error);
        easyRecyclerView.setProgressView(R.layout.view_progress);
    }

}
