package com.zxr.medicalaid.mvp.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zxr.medicalaid.R;
import com.zxr.medicalaid.widget.StickyHeaderDecoration;

/**
 * Created by 猿人 on 2017/6/1.
 */

public class InquiryHeaderAdapter implements StickyHeaderDecoration.IStickyHeaderAdapter<InquiryHeaderAdapter.HeaderHolder> {

    private LayoutInflater mInflater;
    private InquiryContentAdapter adapter;

    public InquiryHeaderAdapter(Context context, InquiryContentAdapter adapter) {
        mInflater = LayoutInflater.from(context);
        this.adapter = adapter;
    }


    @Override
    public long getHeaderId(int position) {

        if(position == 0 || !(adapter.getAllData().get(position).getTime().equals(adapter.getAllData().get(position-1).getTime()))){
            return position;
        }
        return position-1;
    }

    @Override
    public HeaderHolder onCreateHeaderViewHolder(ViewGroup parent) {
        final View view = mInflater.inflate(R.layout.header_item, parent, false);
        return new HeaderHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderHolder viewholder, int position) {
        viewholder.header.setText(adapter.getAllData().get((int) getHeaderId(position)).getTime());
    }

    class HeaderHolder extends RecyclerView.ViewHolder {
        public TextView header;

        public HeaderHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView;
        }
    }
}
