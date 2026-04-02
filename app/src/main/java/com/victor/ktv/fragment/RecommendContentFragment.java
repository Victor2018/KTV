package com.victor.ktv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.victor.ktv.R;
import com.victor.ktv.util.Constant;
import com.victor.ktv.util.DataObservable;
import com.victor.ktv.util.GlideImageLoader;
import com.victor.ktv.util.MainHandler;
import com.victor.ktv.widget.BannerLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class RecommendContentFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.rl_banner)
    BannerLayout bannerLayout;//顶部广告栏控件

    @Bind(R.id.iv_hot_song_list)
    ImageView mIvHotSongList;

    @Bind(R.id.fl_singer)
    FrameLayout mFlSinger;

    @Bind(R.id.fl_song_title)
    FrameLayout mFlSongTitle;

    @Bind(R.id.fl_daily_hot_song)
    FrameLayout mFlDailyHotSong;

    @Bind(R.id.fl_photo_mv)
    FrameLayout mFlPhotoMv;


    public static RecommendContentFragment newInstance () {
        RecommendContentFragment fragment = new RecommendContentFragment();
        Bundle bundle = new Bundle();
//        bundle.putInt(FOLLOW_USER_ID_KEY,followUserId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_recommend_content;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
        initData();
    }

    public void initialize () {
        mIvHotSongList.setOnClickListener(this);
        mFlSinger.setOnClickListener(this);
        mFlSongTitle.setOnClickListener(this);
        mFlDailyHotSong.setOnClickListener(this);
        mFlPhotoMv.setOnClickListener(this);
    }


    private void initData() {
        final List<Integer> urls = new ArrayList<>();
        urls.add(R.mipmap.img_recommend_banner);
        urls.add(R.mipmap.img_singer);
        bannerLayout.setImageLoader(new GlideImageLoader());
        bannerLayout.setViewUrls(urls);

        //添加监听事件
        bannerLayout.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });
    }

    @Override
    public boolean handleBackEvent() {
        return false;
    }

    @Override
    public void freshFragData() {

    }

    @Override
    public void onClick(View view) {
        RecommendDetailFragment recommendDetailFragment = (RecommendDetailFragment) getParentFragment();
        switch (view.getId()) {
            case R.id.iv_hot_song_list:
                if (recommendDetailFragment != null) {
                    recommendDetailFragment.switchFragment(HotSongListFragment.newInstance());
                }
                break;
            case R.id.fl_singer:
                if (recommendDetailFragment != null) {
                    recommendDetailFragment.switchFragment(SingerFragment.newInstance());
                }
                break;
            case R.id.fl_song_title:
                if (recommendDetailFragment != null) {
                    recommendDetailFragment.setCurrentPagePosition(1);
                }
                break;
            case R.id.fl_daily_hot_song:
                if (recommendDetailFragment != null) {
                    recommendDetailFragment.switchFragment(HotSongListFragment.newInstance());
                }
                break;
            case R.id.fl_photo_mv:
                if (recommendDetailFragment != null) {
                    recommendDetailFragment.switchFragment(PhotoMvFragment.newInstance());
                }
                break;
        }
    }
}
