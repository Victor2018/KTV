package com.victor.ktv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;

import com.victor.ktv.MainActivity;
import com.victor.ktv.R;

import butterknife.Bind;

public class SingContentFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.fl_singer)
    FrameLayout mFlSinger;

    @Bind(R.id.fl_song_title)
    FrameLayout mFlSongTitle;

    @Bind(R.id.fl_mcgaar_ranking)
    FrameLayout mFlSongMcgaarRanking;

    @Bind(R.id.fl_mls_hot)
    FrameLayout mFlMlsHot;

    @Bind(R.id.fl_new_sing)
    FrameLayout mFlNewSing;

    @Bind(R.id.fl_category)
    FrameLayout mFlCategory;

    @Bind(R.id.fl_love_song_duet)
    FrameLayout mFlLoveSongDuet;

    @Bind(R.id.fl_original_vocal_chart)
    FrameLayout mFlOriginalVocalChart;

    public static SingContentFragment newInstance () {
        SingContentFragment fragment = new SingContentFragment();
        Bundle bundle = new Bundle();
//        bundle.putInt(FOLLOW_USER_ID_KEY,followUserId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_sing_content;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
        initData();
    }

    public void initialize () {
        mFlSinger.setOnClickListener(this);
        mFlSongTitle.setOnClickListener(this);
        mFlSongMcgaarRanking.setOnClickListener(this);
        mFlMlsHot.setOnClickListener(this);
        mFlNewSing.setOnClickListener(this);
        mFlCategory.setOnClickListener(this);
        mFlLoveSongDuet.setOnClickListener(this);
        mFlOriginalVocalChart.setOnClickListener(this);
    }


    private void initData() {
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
        MainActivity mainActivity = (MainActivity) getActivity();
        switch (view.getId()) {
            case R.id.fl_singer:
                if (mainActivity != null) {
                    mainActivity.switchSingerFragment();
                }
                break;
            case R.id.fl_song_title:
            case R.id.fl_mcgaar_ranking:
            case R.id.fl_new_sing:
            case R.id.fl_love_song_duet:
            case R.id.fl_original_vocal_chart:
                if (mainActivity != null) {
                    mainActivity.switchSongFragment();
                }
                break;
            case R.id.fl_mls_hot:
                if (mainActivity != null) {
                    mainActivity.switchHotFragment();
                }
                break;
            case R.id.fl_category:
                SingFragment singFragment = (SingFragment) getParentFragment();
                if (singFragment != null) {
                    singFragment.switchFragment(CategoryFragment.newInstance());
                }
                break;
        }
    }
}
