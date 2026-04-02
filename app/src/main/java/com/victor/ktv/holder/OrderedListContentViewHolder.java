package com.victor.ktv.holder;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.victor.ktv.R;


/**
 * Created by Victor on 2017/11/24.
 */

public class OrderedListContentViewHolder extends ContentViewHolder implements View.OnClickListener {
    public static final int ONITEM_CLICK = 0;
    public static final int ONITEM_VOTE_CLICK = 1;
    public static final int ONITEM_PULL_VOTE_CLICK = 2;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    public TextView mTvTitle,mTvSinger,mTvLanguage;

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public OrderedListContentViewHolder(View view) {
        super(view);
        mTvTitle = view.findViewById(R.id.tv_title);
        mTvSinger = view.findViewById(R.id.tv_singer);
        mTvLanguage = view.findViewById(R.id.tv_language);
        view.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(null, view, getAdapterPosition(), 0);
        }
    }


}
