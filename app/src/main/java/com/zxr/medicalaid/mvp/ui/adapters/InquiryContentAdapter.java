package com.zxr.medicalaid.mvp.ui.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.entity.Person;
import com.zxr.medicalaid.widget.CircleImageView;

/**
 * Created by 猿人 on 2017/6/1.
 */

public class InquiryContentAdapter extends RecyclerArrayAdapter<Person> {


    public InquiryContentAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContentHolder(parent, R.layout.recyclerview_person_list_item);
    }



    class ContentHolder extends BaseViewHolder<Person>{

        CircleImageView patinentImg;
        TextView patinentName,timeTv;

        public ContentHolder(ViewGroup parent, @LayoutRes int res) {
            super(parent, res);
            patinentImg = $(R.id.patient_image);
            patinentName = $(R.id.patient_name);
            timeTv = $(R.id.time);
        }

        @Override
        public void setData(Person data) {
            timeTv.setText(data.getTime());
            patinentName.setText(data.getName());
            Glide.with(getContext())
                    .load(data.getImage_url())
                    .crossFade()
                    .placeholder(R.drawable.default_image)
                    .into(patinentImg);
        }
    }
}
