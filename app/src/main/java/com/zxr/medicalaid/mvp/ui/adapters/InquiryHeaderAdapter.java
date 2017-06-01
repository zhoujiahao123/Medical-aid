package com.zxr.medicalaid.mvp.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.widget.StickyHeaderDecoration;

/**
 * Created by 猿人 on 2017/6/1.
 */

public class InquiryHeaderAdapter implements  StickyHeaderDecoration.IStickyHeaderAdapter<InquiryHeaderAdapter.HeaderHolder>{

    private LayoutInflater mInflater;

    public InquiryHeaderAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public long getHeaderId(int position) {
        Log.i("测试","position"+position);
        return position/3;
    }

    @Override
    public HeaderHolder onCreateHeaderViewHolder(ViewGroup parent) {
        final View view = mInflater.inflate(R.layout.header_item,parent,false);
        return new HeaderHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderHolder viewholder, int position) {
        Log.i("测试","onBind");
        viewholder.header.setText("第"+getHeaderId(position)+"组");
    }

    class HeaderHolder extends RecyclerView.ViewHolder {
        public TextView header;

        public HeaderHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView;
        }
    }
}
