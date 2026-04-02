package com.victor.ktv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;

import com.victor.ktv.MainActivity;
import com.victor.ktv.R;

import butterknife.Bind;

public class SingFragment extends BaseFragment {

    private Fragment currentFragment;

    public static SingFragment newInstance () {
        SingFragment fragment = new SingFragment();
        Bundle bundle = new Bundle();
//        bundle.putInt(FOLLOW_USER_ID_KEY,followUserId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_sing;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
        initData();
    }

    public void initialize () {
        switchFragment(currentFragment, SingContentFragment.newInstance());
    }


    private void initData() {
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
            ft.add(R.id.fl_sing_container, toFragment);
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
}
