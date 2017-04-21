package com.zxr.medicalaid.mvp.ui.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.mvp.entity.Person;
import com.zxr.medicalaid.widget.CircleImageView;

/**
 * Created by 猿人 on 2017/4/21.
 */

public class PatientListAdapter extends RecyclerArrayAdapter<Person> {

    private final String TAG = "PatientListAdapter";
    Context mContext;

    public PatientListAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new PatientListViewHolder(parent, R.layout.recyclerview_person_list_item);
    }

    class PatientListViewHolder extends BaseViewHolder<Person> {

        CircleImageView patientImage;
        TextView patientName, time;

        public PatientListViewHolder(ViewGroup parent, @LayoutRes int res) {
            super(parent, res);
            Log.i(TAG, "onConstruct");
            patientImage = $(R.id.patient_image);
            patientName = $(R.id.patient_name);
            time = $(R.id.time);
        }

        @Override
        public void setData(Person data) {
            Glide.with(mContext).load(data.getImage_url()).crossFade().into(patientImage);
            patientName.setText(data.getName());
            time.setText(data.getTime());
        }
    }
}
