package com.victor.ktv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.victor.ktv.R;
import com.victor.ktv.module.Player;
import com.victor.ktv.util.MainHandler;

import butterknife.Bind;

public class LightFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    @Bind(R.id.rg_atmosphere1)
    RadioGroup mRgAtmosphere1;

    @Bind(R.id.rg_atmosphere2)
    RadioGroup mRgAtmosphere2;

    @Bind(R.id.rb_1)
    RadioButton mRb1;

    @Bind(R.id.rb_2)
    RadioButton mRb2;

    @Bind(R.id.rb_3)
    RadioButton mRb3;

    @Bind(R.id.rb_4)
    RadioButton mRb4;

    @Bind(R.id.rb_5)
    RadioButton mRb5;

    @Bind(R.id.rb_6)
    RadioButton mRb6;

    @Bind(R.id.rb_7)
    RadioButton mRb7;

    @Bind(R.id.rb_8)
    RadioButton mRb8;


    public static LightFragment newInstance () {
        LightFragment fragment = new LightFragment();
        Bundle bundle = new Bundle();
//        bundle.putInt(FOLLOW_USER_ID_KEY,followUserId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_light;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
    }

    public void initialize () {
        mRb1.setOnCheckedChangeListener(this);
        mRb2.setOnCheckedChangeListener(this);
        mRb3.setOnCheckedChangeListener(this);
        mRb4.setOnCheckedChangeListener(this);
        mRb5.setOnCheckedChangeListener(this);
        mRb6.setOnCheckedChangeListener(this);
        mRb7.setOnCheckedChangeListener(this);
        mRb8.setOnCheckedChangeListener(this);
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
        switch (compoundButton.getId()) {
            case R.id.rb_1:
            case R.id.rb_2:
            case R.id.rb_3:
            case R.id.rb_4:
                mRgAtmosphere2.clearCheck();
                break;
            case R.id.rb_5:
            case R.id.rb_6:
            case R.id.rb_7:
            case R.id.rb_8:
                mRgAtmosphere1.clearCheck();
                break;
        }
    }
}
