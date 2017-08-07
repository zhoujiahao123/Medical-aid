package com.zxr.medicalaid.mvp.ui.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.entity.MedicalDataInfo;

/**
 * Created by 张兴锐 on 2017/8/7.
 */

public class MedicalDateSettingAdapter extends RecyclerArrayAdapter<MedicalDataInfo> {
    
    public MedicalDateSettingAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MedicalDateSettingViewHolder(parent, R.layout.recyclerview_medical_date_item);
    }
    
    class MedicalDateSettingViewHolder extends BaseViewHolder<MedicalDataInfo>{

        TextView drawerNum,currentName,productDate,shelfLife;
        
        public MedicalDateSettingViewHolder(ViewGroup parent, @LayoutRes int res) {
            super(parent, res);
            drawerNum = $(R.id.drawer_num);
            currentName = $(R.id.current_medical_name);
            productDate = $(R.id.product_date);
            shelfLife = $(R.id.shelf_life);
        }

        @Override
        public void setData(MedicalDataInfo data) {
            super.setData(data);
            drawerNum.setText(data.getDrawerNum()+"号");
            currentName.setText(data.getName());
            productDate.setText(data.getProductDate());
            shelfLife.setText(data.getShelfLife());
        }
    }
    
}
