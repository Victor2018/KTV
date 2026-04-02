package com.victor.ktv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.victor.ktv.R;

public class ExpressionFragment extends BaseFragment implements View.OnClickListener {


    public static ExpressionFragment newInstance () {
        ExpressionFragment fragment = new ExpressionFragment();
        Bundle bundle = new Bundle();
//        bundle.putInt(FOLLOW_USER_ID_KEY,followUserId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_expression;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
    }

    public void initialize () {
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
}
