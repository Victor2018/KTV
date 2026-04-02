package com.victor.ktv.dialog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.victor.ktv.R;
import com.victor.ktv.adapter.ViewPagerAdapter;
import com.victor.ktv.fragment.ExpressionFragment;
import com.victor.ktv.fragment.KtvFragment;
import com.victor.ktv.fragment.LightFragment;
import com.victor.ktv.fragment.OrderedListFragment;
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
public class AtmosphereDialog extends AbsDialogFragment implements View.OnClickListener {


    @Bind(R.id.tabs)
    TabLayout mTabLayout;

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    private String[] pagerTitles = new String[]{"灯光","表情"};
    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected int bindContentView() {
        return R.layout.dialog_atmosphere;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void handleWindow(Window window) {
        window.setGravity(Gravity.BOTTOM | Gravity.RIGHT);
    }

    @Override
    public void handleLayoutParams(WindowManager.LayoutParams wlp) {
        wlp.width = DensityUtil.getScreenWidth(getActivity()) * 5 / 10;
        wlp.height = DensityUtil.getScreenHeight(getActivity()) * 7 / 10;
        wlp.windowAnimations = R.style.RightDialogAnimShow;
    }


    @Override
    protected void initView(View rootView) {
        super.initView(rootView);
        fragmentList.add(LightFragment.newInstance());
        fragmentList.add(ExpressionFragment.newInstance());

        mViewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mViewPagerAdapter.setFragTitles(pagerTitles);
        mViewPagerAdapter.setFrags(fragmentList);
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.setOffscreenPageLimit(fragmentList.size());
        mTabLayout.setupWithViewPager(mViewPager);

    }




    @Override
    public void onClick(View v) {
        int id = v.getId();
    }

}
