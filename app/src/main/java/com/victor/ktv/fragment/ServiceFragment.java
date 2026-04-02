package com.victor.ktv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.victor.ktv.R;

public class ServiceFragment extends BaseFragment {


    public static ServiceFragment newInstance () {
        ServiceFragment fragment = new ServiceFragment();
        Bundle bundle = new Bundle();
//        bundle.putInt(FOLLOW_USER_ID_KEY,followUserId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_service;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
        initData();
    }

    public void initialize () {
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

}
