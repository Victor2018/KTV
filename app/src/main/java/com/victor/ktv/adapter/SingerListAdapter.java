package com.victor.ktv.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.victor.ktv.R;
import com.victor.ktv.data.MusicData;
import com.victor.ktv.data.SingerInfo;
import com.victor.ktv.holder.SingerListContentViewHolder;
import com.victor.ktv.holder.SongListContentViewHolder;

/**
 * @Author Victor
 * @Date Create on 2018/1/17 18:01.
 * @Describe
 */

public class SingerListAdapter extends BaseRecycleAdapter<SingerInfo, RecyclerView.ViewHolder> {
    public SingerListAdapter(Context context, AdapterView.OnItemClickListener listener) {
        super(context,listener);
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeadVHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindHeadVHolder(RecyclerView.ViewHolder viewHolder, SingerInfo data, int position) {

    }

    @Override
    public RecyclerView.ViewHolder onCreateContentVHolder(ViewGroup parent, int viewType) {
        return new SingerListContentViewHolder(mLayoutInflater.inflate(R.layout.rv_singer_list_cell, parent, false));
    }

    @Override
    public void onBindContentVHolder(RecyclerView.ViewHolder viewHolder, SingerInfo data, int position) {
        SingerListContentViewHolder contentViewHolder = (SingerListContentViewHolder) viewHolder;

        contentViewHolder.mTvSinger.setText(data.artist);

        contentViewHolder.setOnItemClickListener(mOnItemClickListener);
    }


}
