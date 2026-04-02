package com.victor.ktv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.victor.ktv.R;
import com.victor.ktv.adapter.SongListAdapter;
import com.victor.ktv.util.HorizontalPageLayoutManager;
import com.victor.ktv.util.ImageUtil;
import com.victor.ktv.util.PagingItemDecoration;
import com.victor.ktv.util.QrCodeUtil;
import com.victor.ktv.widget.PagingScrollHelper;

import butterknife.Bind;

public class PhotoMvFragment extends BaseFragment implements View.OnClickListener {


    @Bind(R.id.tv_back)
    TextView mTvBack;

    @Bind(R.id.iv_qr)
    ImageView mIvQr;

    @Bind(R.id.iv_secondary_home)
    ImageView mTvSecondaryHome;


    public static PhotoMvFragment newInstance () {
        PhotoMvFragment fragment = new PhotoMvFragment();
        Bundle bundle = new Bundle();
//        bundle.putInt(FOLLOW_USER_ID_KEY,followUserId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_photo_mv;
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

        mIvQr.setImageBitmap(QrCodeUtil.createBitmap("423099",300,300,
                ImageUtil.getBitmapFormResources(getContext(),R.mipmap.ic_logo)));

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
                RecommendFragment recommendFragment = (RecommendFragment) getParentFragment();
                if (recommendFragment != null) {
                    recommendFragment.switchFragment(RecommendDetailFragment.newInstance(0));
                }
                break;
        }
    }
}
