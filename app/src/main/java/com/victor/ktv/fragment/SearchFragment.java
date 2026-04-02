package com.victor.ktv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.victor.ktv.MainActivity;
import com.victor.ktv.R;
import com.victor.ktv.adapter.ViewPagerAdapter;
import com.victor.ktv.util.SoftKeyboardUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class SearchFragment extends BaseFragment implements View.OnClickListener {


    @Bind(R.id.tv_back)
    TextView mTvBack;

    @Bind(R.id.iv_secondary_home)
    ImageView mTvSecondaryHome;

    @Bind(R.id.tabs)
    TabLayout mTabLayout;

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Bind(R.id.et_search)
    EditText mEtSearch;

    @Bind(R.id.iv_search_empty)
    ImageView mIvSearchEmpty;

    @Bind(R.id.tv_search_empty_tip)
    TextView mTvSearchEmptyTip;

    private String[] pagerTitles = new String[]{"歌曲","歌名","歌星","歌词"};
    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPagerAdapter mViewPagerAdapter;


    public static SearchFragment newInstance () {
        SearchFragment fragment = new SearchFragment();
        Bundle bundle = new Bundle();
//        bundle.putInt(FOLLOW_USER_ID_KEY,followUserId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_search;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
        initData();
    }

    public void initialize () {
        fragmentList.add(SongListFragment.newInstance());
        fragmentList.add(SongListFragment.newInstance());
        fragmentList.add(SongListFragment.newInstance());
        fragmentList.add(SongListFragment.newInstance());

        mViewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mViewPagerAdapter.setFragTitles(pagerTitles);
        mViewPagerAdapter.setFrags(fragmentList);
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.setOffscreenPageLimit(fragmentList.size());
        mTabLayout.setupWithViewPager(mViewPager);

        mTvBack.setOnClickListener(this);
        mTvSecondaryHome.setOnClickListener(this);

        mEtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId,KeyEvent event) {
                if (actionId== EditorInfo.IME_ACTION_SEND ||(event!=null&&event.getKeyCode()== KeyEvent.KEYCODE_ENTER)) {
                    mIvSearchEmpty.setVisibility(View.VISIBLE);
                    mTvSearchEmptyTip.setVisibility(View.VISIBLE);
                    mViewPager.setVisibility(View.GONE);
                    SoftKeyboardUtils.hideSoftKeyboard(getActivity(),mEtSearch);
                    return true;
                }
                return false;
            }
        });
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
                MainActivity mainActivity = (MainActivity) getActivity();
                if (mainActivity != null) {
                    mainActivity.setFragAction(0);
                }
                RecommendFragment recommendFragment = (RecommendFragment) getParentFragment();
                if (recommendFragment != null) {
                    recommendFragment.switchFragment(RecommendDetailFragment.newInstance(0));
                }
                break;
        }
    }

}
