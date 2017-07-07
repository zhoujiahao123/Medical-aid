package com.zxr.medicalaid.mvp.ui.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.zxr.medicalaid.R;

import com.zxr.medicalaid.mvp.entity.PrescriptionItem;

/**
 * Created by 猿人 on 2017/6/2.
 */

public class PrescribeTableAdapter extends RecyclerArrayAdapter<PrescriptionItem> {

    public PrescribeTableAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new PrescribeTableVewiHolder(parent, R.layout.prescribe_table_normal);
    }

    class PrescribeTableVewiHolder extends BaseViewHolder<PrescriptionItem> {
        TextView medicineNameTv, weightTv;

        public PrescribeTableVewiHolder(ViewGroup parent, @LayoutRes int res) {
            super(parent, res);
            medicineNameTv = $(R.id.medicine_name);
            weightTv = $(R.id.medicine_weight);
        }

        @Override
        public void setData(PrescriptionItem data) {
            super.setData(data);
            medicineNameTv.setText(data.getName());
            weightTv.setText(data.getWeight());
        }
    }

}
