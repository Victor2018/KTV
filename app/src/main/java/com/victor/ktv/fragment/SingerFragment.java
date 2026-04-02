package com.victor.ktv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.victor.ktv.R;
import com.victor.ktv.adapter.SongListAdapter;
import com.victor.ktv.adapter.ViewPagerAdapter;
import com.victor.ktv.data.MusicData;
import com.victor.ktv.util.HorizontalPageLayoutManager;
import com.victor.ktv.util.PagingItemDecoration;
import com.victor.ktv.widget.PagingScrollHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class SingerFragment extends BaseFragment implements View.OnClickListener {


    private Fragment currentFragment;

    public static SingerFragment newInstance () {
        SingerFragment fragment = new SingerFragment();
        Bundle bundle = new Bundle();
//        bundle.putInt(FOLLOW_USER_ID_KEY,followUserId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_singer;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
        initData();
    }

    public void initialize () {
        switchFragment(currentFragment, SingerContentFragment.newInstance());
    }

    private void initData() {

    }

    public void switchParentFragment(Fragment toFragment) {
        RecommendFragment recommendFragment = (RecommendFragment) getParentFragment();
        if (recommendFragment != null) {
            recommendFragment.switchFragment(toFragment);
        }
    }

    public void switchFragment(Fragment toFragment) {
        switchFragment(currentFragment,toFragment);
    }
    private void switchFragment(Fragment fromFragment, Fragment toFragment) {
        if (currentFragment != null) {
            if (currentFragment.getClass().getName() == toFragment.getClass().getName()) {
                return;
            }
        }

        currentFragment = toFragment;

        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.anim_fragment_enter, R.anim.anim_fragment_exit);
        if (toFragment.isAdded()) {
            ft.show(toFragment);
        } else {
            ft.add(R.id.fl_singer_container, toFragment);
        }
        if (fromFragment != null) {
            ft.hide(fromFragment);
        }
        ft.commitAllowingStateLoss();
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
            case R.id.tv_back:
            case R.id.iv_secondary_home:
                switchFragment(SingerContentFragment.newInstance());
                break;
        }
    }
}
