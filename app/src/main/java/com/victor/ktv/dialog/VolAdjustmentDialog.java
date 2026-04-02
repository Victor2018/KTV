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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.victor.ktv.R;
import com.victor.ktv.adapter.ViewPagerAdapter;
import com.victor.ktv.fragment.KtvFragment;
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
public class VolAdjustmentDialog extends AbsDialogFragment implements View.OnClickListener {

    @Bind(R.id.pb_vol)
    ProgressBar mPbVol;

    @Bind(R.id.pb_mike)
    ProgressBar mPbMike;

    @Bind(R.id.pb_tone)
    ProgressBar mPbTone;

    @Bind(R.id.iv_vol_sub)
    ImageView mIvVolSub;

    @Bind(R.id.iv_vol_add)
    ImageView mIvVolAdd;

    @Bind(R.id.iv_mike_sub)
    ImageView mIvMikeSub;

    @Bind(R.id.iv_mike_add)
    ImageView mIvMikeAdd;

    @Bind(R.id.iv_tone_sub)
    ImageView mIvToneSub;

    @Bind(R.id.iv_tone_add)
    ImageView mIvToneAdd;

    @Bind(R.id.tv_vol)
    TextView mTvVol;

    @Bind(R.id.tv_mike)
    TextView mTvMike;

    @Bind(R.id.tv_tone)
    TextView mTvTone;

    @Override
    protected int bindContentView() {
        return R.layout.dialog_vol_adjustment;
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
        wlp.width = DensityUtil.getScreenWidth(getActivity()) * 6 / 10;
        wlp.height = DensityUtil.getScreenHeight(getActivity()) * 8 / 10;
        wlp.windowAnimations = R.style.RightDialogAnimShow;
    }


    @Override
    protected void initView(View rootView) {
        super.initView(rootView);
        mIvVolSub.setOnClickListener(this);
        mIvVolAdd.setOnClickListener(this);
        mIvMikeSub.setOnClickListener(this);
        mIvMikeAdd.setOnClickListener(this);
        mIvToneSub.setOnClickListener(this);
        mIvToneAdd.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        int id = v.getId();
        int current = 0;
        switch (id) {
            case R.id.iv_vol_sub:
                current = mPbVol.getProgress();
                current -= 1;
                if (current < 0) {
                    current = 0;
                }
                mPbVol.setProgress(current);
                mTvVol.setText(String.valueOf(current));
                break;
            case R.id.iv_vol_add:
                current = mPbVol.getProgress();
                current += 1;
                if (current > mPbVol.getMax()) {
                    current = mPbVol.getMax();
                }
                mPbVol.setProgress(current);
                mTvVol.setText(String.valueOf(current));
                break;
            case R.id.iv_mike_sub:
                current = mPbMike.getProgress();
                current -= 1;
                if (current < 0) {
                    current = 0;
                }
                mPbMike.setProgress(current);
                mTvMike.setText(String.valueOf(current));
                break;
            case R.id.iv_mike_add:
                current = mPbMike.getProgress();
                current += 1;
                if (current > mPbMike.getMax()) {
                    current = mPbMike.getMax();
                }
                mPbMike.setProgress(current);
                mTvMike.setText(String.valueOf(current));
                break;
            case R.id.iv_tone_sub:
                current = mPbTone.getProgress();
                current -= 1;
                if (current < 0) {
                    current = 0;
                }
                mPbTone.setProgress(current);
                mTvTone.setText(String.valueOf(current));
                break;
            case R.id.iv_tone_add:
                current = mPbTone.getProgress();
                current += 1;
                if (current > mPbTone.getMax()) {
                    current = mPbTone.getMax();
                }
                mPbTone.setProgress(current);
                mTvTone.setText(String.valueOf(current));
                break;
        }
    }

}
