package com.victor.ktv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.victor.ktv.R;
import com.victor.ktv.module.Player;
import com.victor.ktv.util.MainHandler;

import butterknife.Bind;

public class KtvFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    @Bind(R.id.tv_light_screen)
    TextView mTvLightScreen;

    @Bind(R.id.toggle_light_screen)
    Switch mToggleLightScreen;

    @Bind(R.id.sv_play)
    SurfaceView mSvPlay;

    private Player mPlayer;

    public static KtvFragment newInstance () {
        KtvFragment fragment = new KtvFragment();
        Bundle bundle = new Bundle();
//        bundle.putInt(FOLLOW_USER_ID_KEY,followUserId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_ktv;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
    }

    public void initialize () {
        mToggleLightScreen.setOnCheckedChangeListener(this);

        mPlayer = new Player(mSvPlay,MainHandler.get());
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
        switch (view.getId()) {
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        mTvLightScreen.setText(b ? "息屏" : "亮屏");
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPlayer != null) {
            mPlayer.resume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mPlayer != null) {
            mPlayer.pause();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer = null;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (mPlayer == null) return;
        if (isVisibleToUser) {
            if (TextUtils.isEmpty(mPlayer.getLastPlayUrl())) {
                mPlayer.playUrl("http://v.btzx.com.cn:1935/live/weishi.stream/playlist.m3u8",true);
            } else {
                mPlayer.resume();
            }
        } else {
            mPlayer.pause();
        }
    }
}
