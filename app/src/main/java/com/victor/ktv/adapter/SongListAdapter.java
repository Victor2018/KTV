package com.victor.ktv.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.victor.ktv.R;
import com.victor.ktv.data.MusicData;
import com.victor.ktv.holder.SongListContentViewHolder;

/**
 * @Author Victor
 * @Date Create on 2018/1/17 18:01.
 * @Describe
 */

public class SongListAdapter extends BaseRecycleAdapter<MusicData, RecyclerView.ViewHolder> {
    private int currentPosition = -1;
    public SongListAdapter(Context context, AdapterView.OnItemClickListener listener) {
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
        return new SongListContentViewHolder(mLayoutInflater.inflate(R.layout.rv_song_list_cell, parent, false));
    }

    @Override
    public void onBindContentVHolder(RecyclerView.ViewHolder viewHolder, MusicData data, int position) {
        SongListContentViewHolder contentViewHolder = (SongListContentViewHolder) viewHolder;

        contentViewHolder.mTvTitle.setText(data.title);
        contentViewHolder.mTvSinger.setText(data.artist);

        if (position == 0) {
            contentViewHolder.mIvRanking.setImageResource(R.mipmap.ic_ranking1);
            contentViewHolder.mTvRanking.setVisibility(View.GONE);
            contentViewHolder.mIvRanking.setVisibility(View.VISIBLE);
        } else if (position == 1) {
            contentViewHolder.mIvRanking.setImageResource(R.mipmap.ic_ranking2);
            contentViewHolder.mTvRanking.setVisibility(View.GONE);
            contentViewHolder.mIvRanking.setVisibility(View.VISIBLE);
        } else if (position == 2) {
            contentViewHolder.mIvRanking.setImageResource(R.mipmap.ic_ranking3);
            contentViewHolder.mTvRanking.setVisibility(View.GONE);
            contentViewHolder.mIvRanking.setVisibility(View.VISIBLE);
        } else {
            contentViewHolder.mTvRanking.setText(String.valueOf(position + 1));
            contentViewHolder.mTvRanking.setVisibility(View.VISIBLE);
            contentViewHolder.mIvRanking.setVisibility(View.GONE);
        }

        contentViewHolder.setOnItemClickListener(mOnItemClickListener);
    }

    public void setCurrentPosition (int position) {
        currentPosition = position;
        notifyDataSetChanged();
    }

}
