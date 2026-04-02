package com.victor.ktv.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.victor.ktv.R;
import com.victor.ktv.data.MusicData;
import com.victor.ktv.holder.OrderedListContentViewHolder;
import com.victor.ktv.holder.SongListContentViewHolder;

/**
 * @Author Victor
 * @Date Create on 2018/1/17 18:01.
 * @Describe
 */

public class OrderedListAdapter extends BaseRecycleAdapter<MusicData, RecyclerView.ViewHolder> {
    private int currentPosition = -1;
    public OrderedListAdapter(Context context, AdapterView.OnItemClickListener listener) {
        super(context,listener);
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeadVHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindHeadVHolder(RecyclerView.ViewHolder viewHolder, MusicData data, int position) {

    }

    @Override
    public RecyclerView.ViewHolder onCreateContentVHolder(ViewGroup parent, int viewType) {
        return new OrderedListContentViewHolder(mLayoutInflater.inflate(R.layout.rv_ordered_list_cell, parent, false));
    }

    @Override
    public void onBindContentVHolder(RecyclerView.ViewHolder viewHolder, MusicData data, int position) {
        OrderedListContentViewHolder contentViewHolder = (OrderedListContentViewHolder) viewHolder;

        contentViewHolder.mTvTitle.setText(data.title);
        contentViewHolder.mTvSinger.setText(data.artist);


        contentViewHolder.setOnItemClickListener(mOnItemClickListener);
    }

    public void setCurrentPosition (int position) {
        currentPosition = position;
        notifyDataSetChanged();
    }

}
