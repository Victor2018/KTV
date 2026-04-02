package com.victor.ktv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.victor.ktv.R;
import com.victor.ktv.util.Constant;

public class RecommendFragment extends BaseFragment {

    private Fragment currentFragment;

    private int action;

    public static RecommendFragment newInstance (int action) {
        RecommendFragment fragment = new RecommendFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.INTENT_ACTION_KEY,action);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_recommend;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initialize();
    }

    public void initialize () {
        if (action == Constant.Action.SWITCH_SEACH_FRAG) {
            switchFragment(SearchFragment.newInstance());
        } else {
            switchFragment(RecommendDetailFragment.newInstance(action));
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
            ft.add(R.id.fl_recommend_container, toFragment);
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
    public void onDestroyView() {
        super.onDestroyView();
    }


    public void switchSongFragment() {
        if (currentFragment == null) return;
        if (currentFragment instanceof RecommendDetailFragment) {
            RecommendDetailFragment recommendDetailFragment = (RecommendDetailFragment) currentFragment;
            if (recommendDetailFragment != null) {
                recommendDetailFragment.setCurrentPagePosition(1);
            }
        }
    }

    public void switchHotFragment() {
        if (currentFragment == null) return;
        if (currentFragment instanceof RecommendDetailFragment) {
            RecommendDetailFragment recommendDetailFragment = (RecommendDetailFragment) currentFragment;
            if (recommendDetailFragment != null) {
                recommendDetailFragment.switchFragment(HotSongListFragment.newInstance());
            }
        }
    }

    public void switchSingerFragment() {
        if (currentFragment == null) return;
        if (currentFragment instanceof RecommendDetailFragment) {
            RecommendDetailFragment recommendDetailFragment = (RecommendDetailFragment) currentFragment;
            if (recommendDetailFragment != null) {
                recommendDetailFragment.switchFragment(SingerFragment.newInstance());
            }
        }
    }
}
