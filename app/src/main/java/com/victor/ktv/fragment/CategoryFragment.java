package com.victor.ktv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.victor.ktv.R;

import butterknife.Bind;

public class CategoryFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.tv_back)
    TextView mTvBack;

    @Bind(R.id.iv_secondary_home)
    ImageView mTvSecondaryHome;

    public static CategoryFragment newInstance () {
        CategoryFragment fragment = new CategoryFragment();
        Bundle bundle = new Bundle();
//        bundle.putInt(FOLLOW_USER_ID_KEY,followUserId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_category;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
        initData();
    }

    public void initialize () {
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
                SingFragment singFragment = (SingFragment) getParentFragment();
                if (singFragment != null) {
                    singFragment.switchFragment(SingContentFragment.newInstance());
                }
                break;
        }
    }
}
