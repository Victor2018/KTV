package com.victor.ktv.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.victor.ktv.R;
import com.victor.ktv.adapter.ViewPagerAdapter;
import com.victor.ktv.fragment.KtvFragment;
import com.victor.ktv.fragment.LeaderboardFragment;
import com.victor.ktv.fragment.OrderedListFragment;
import com.victor.ktv.fragment.RecommendContentFragment;
import com.victor.ktv.fragment.SongListFragment;
import com.victor.ktv.fragment.SungFragment;
import com.victor.ktv.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


/*
 * -----------------------------------------------------------------
 * Copyright (C) 2018-2028, by Victor, All rights reserved.
 * -----------------------------------------------------------------
 * File: SongsOrderedDialog.java
 * Author: Victor
 * Date: 2020/2/5 14:05
 * Description:
 * -----------------------------------------------------------------
 */

@SuppressLint("ValidFragment")
public class SongsOrderedDialog extends AbsDialogFragment implements View.OnClickListener, ViewPager.OnPageChangeListener {


    @Bind(R.id.iv_random_order)
    ImageView mIvRandomOrder;

    @Bind(R.id.tabs)
    TabLayout mTabLayout;

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    private String[] pagerTitles = new String[]{"已选","已唱","KTV"};
    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPagerAdapter mViewPagerAdapter;


    @Override
    protected int bindContentView() {
        return R.layout.dialog_songs_ordered;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void handleWindow(Window window) {
        window.setGravity(Gravity.CENTER);
    }

    @Override
    public void handleLayoutParams(WindowManager.LayoutParams wlp) {
        wlp.width = DensityUtil.getScreenWidth(getActivity()) * 6 / 10;
        wlp.height = DensityUtil.getScreenHeight(getActivity()) * 7 / 10;
        wlp.windowAnimations = R.style.BottomDialogAnimShow;
    }


    @Override
    protected void initView(View rootView) {
        super.initView(rootView);
        fragmentList.add(OrderedListFragment.newInstance());
        fragmentList.add(SungFragment.newInstance());
        fragmentList.add(KtvFragment.newInstance());

        mViewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mViewPagerAdapter.setFragTitles(pagerTitles);
        mViewPagerAdapter.setFrags(fragmentList);
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.setOffscreenPageLimit(fragmentList.size());
        mTabLayout.setupWithViewPager(mViewPager);

        mViewPager.setOnPageChangeListener(this);
    }




    @Override
    public void onClick(View v) {
        int id = v.getId();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mIvRandomOrder.setVisibility(position == 0 ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
