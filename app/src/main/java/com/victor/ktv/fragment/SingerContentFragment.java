package com.victor.ktv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.victor.ktv.R;
import com.victor.ktv.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class SingerContentFragment extends BaseFragment implements View.OnClickListener {


    @Bind(R.id.tv_back)
    TextView mTvBack;

    @Bind(R.id.iv_secondary_home)
    ImageView mTvSecondaryHome;

    @Bind(R.id.tabs)
    TabLayout mTabLayout;

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    private String[] pagerTitles = new String[]{"所有歌星","大陆男星","大陆女星"};
    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPagerAdapter mViewPagerAdapter;


    public static SingerContentFragment newInstance () {
        SingerContentFragment fragment = new SingerContentFragment();
        Bundle bundle = new Bundle();
//        bundle.putInt(FOLLOW_USER_ID_KEY,followUserId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_singer_content;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
        initData();
    }

    public void initialize () {
        fragmentList.add(SingerListFragment.newInstance());
        fragmentList.add(SingerListFragment.newInstance());
        fragmentList.add(SingerListFragment.newInstance());

        mViewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mViewPagerAdapter.setFragTitles(pagerTitles);
        mViewPagerAdapter.setFrags(fragmentList);
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.setOffscreenPageLimit(fragmentList.size());
        mTabLayout.setupWithViewPager(mViewPager);

        mTvBack.setOnClickListener(this);
        mTvSecondaryHome.setOnClickListener(this);
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
        switch (view.getId()) {
            case R.id.tv_back:
            case R.id.iv_secondary_home:
                SingerFragment singerFragment = (SingerFragment) getParentFragment();
                if (singerFragment != null) {
                    singerFragment.switchParentFragment(RecommendDetailFragment.newInstance(0));
                }
                break;
        }
    }

    public void switchFragment(Fragment toFragment) {
        SingerFragment singerFragment = (SingerFragment) getParentFragment();
        if (singerFragment != null) {
            singerFragment.switchFragment(toFragment);
        }

    }
}
