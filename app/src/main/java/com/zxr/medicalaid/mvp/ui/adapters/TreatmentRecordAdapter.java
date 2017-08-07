package com.zxr.medicalaid.mvp.ui.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.entity.TreatmentRecordItem;

/**
 * Created by 猿人 on 2017/6/2.
 */

public class TreatmentRecordAdapter extends RecyclerArrayAdapter<TreatmentRecordItem> {

    public TreatmentRecordAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new TreatmentVeiewHolder(parent, R.layout.recyclerview_treatment_record_item);
    }

    class TreatmentVeiewHolder extends BaseViewHolder<TreatmentRecordItem> {
        TextView timeTv;

        public TreatmentVeiewHolder(ViewGroup parent, @LayoutRes int res) {
            super(parent, res);
            timeTv = $(R.id.time);

        }

        @Override
        public void setData(TreatmentRecordItem data) {
            super.setData(data);
            timeTv.setText("时间:" + data.getTime());

        }
    }

}
