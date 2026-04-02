package com.victor.ktv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.victor.ktv.R;
import com.victor.ktv.adapter.ViewPagerAdapter;
import com.victor.ktv.data.RecommendBannerItem;
import com.victor.ktv.util.Constant;
import com.victor.ktv.util.GlideImageLoader;
import com.victor.ktv.util.MainHandler;
import com.victor.ktv.widget.BannerLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class RecommendDetailFragment extends BaseFragment {

    @Bind(R.id.tabs)
    TabLayout mTabLayout;

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    private String[] pagerTitles = new String[]{"热门","歌单","排行榜"};
    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPagerAdapter mViewPagerAdapter;
    private int action;

    public static RecommendDetailFragment newInstance (int action) {
        RecommendDetailFragment fragment = new RecommendDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.INTENT_ACTION_KEY,action);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_recommend_detail;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initialize();
    }

    public void initialize () {
        fragmentList.add(RecommendContentFragment.newInstance());
        fragmentList.add(SongListFragment.newInstance());
        fragmentList.add(LeaderboardFragment.newInstance());

        mViewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mViewPagerAdapter.setFragTitles(pagerTitles);
        mViewPagerAdapter.setFrags(fragmentList);
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.setOffscreenPageLimit(fragmentList.size());
        mTabLayout.setupWithViewPager(mViewPager);

        switch (action) {
            case Constant.Action.SWITCH_SONG_LIST_FRAG:
                mViewPager.setCurrentItem(1);
                break;
            case Constant.Action.SWITCH_HOT_SONG_LIST_FRAG:
                switchFragment(HotSongListFragment.newInstance());
                break;
            case Constant.Action.SWITCH_SINGER_FRAG:
                switchFragment(SingerFragment.newInstance());
                break;
        }
    }


    private void initData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey(Constant.INTENT_ACTION_KEY)) {
                action = bundle.getInt(Constant.INTENT_ACTION_KEY);
            }
        }
    }

    @Override
    public boolean handleBackEvent() {
        return false;
    }

    @Override
    public void freshFragData() {

    }

    public void switchFragment(Fragment toFragment) {
        RecommendFragment recommendFragment = (RecommendFragment) getParentFragment();
        if (recommendFragment != null) {
            recommendFragment.switchFragment(toFragment);
        }
    }

    public void setCurrentPagePosition (int position) {
        if (mViewPager != null) {
            mViewPager.setCurrentItem(position);
        }
    }


}
