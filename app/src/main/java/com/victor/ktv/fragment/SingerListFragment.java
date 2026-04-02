package com.victor.ktv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.victor.ktv.R;
import com.victor.ktv.adapter.SingerListAdapter;
import com.victor.ktv.adapter.SongListAdapter;
import com.victor.ktv.data.MusicData;
import com.victor.ktv.data.SingerInfo;
import com.victor.ktv.util.HorizontalPageLayoutManager;
import com.victor.ktv.util.PagingItemDecoration;
import com.victor.ktv.widget.PagingScrollHelper;

import butterknife.Bind;

public class SingerListFragment extends BaseFragment implements PagingScrollHelper.onPageChangeListener,
        AdapterView.OnItemClickListener, View.OnClickListener {

    @Bind(R.id.rv_singer_list)
    RecyclerView mRvSingerList;

    @Bind(R.id.tv_pre_page)
    TextView mTvPrePage;

    @Bind(R.id.tv_page)
    TextView mTvPage;

    @Bind(R.id.tv_next_page)
    TextView mTvNextPage;

    PagingScrollHelper scrollHelper = new PagingScrollHelper();

    private HorizontalPageLayoutManager horizontalPageLayoutManager;
    private SingerListAdapter singerListAdapter;
    private int currentIndex;

    public static SingerListFragment newInstance () {
        SingerListFragment fragment = new SingerListFragment();
        Bundle bundle = new Bundle();
//        bundle.putInt(FOLLOW_USER_ID_KEY,followUserId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_singer_list;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
        initData();
    }

    public void initialize () {

        singerListAdapter = new SingerListAdapter(getContext(),this);
        singerListAdapter.setHeaderVisible(false);
        singerListAdapter.setFooterVisible(false);

        mRvSingerList.setAdapter(singerListAdapter);

        horizontalPageLayoutManager = new HorizontalPageLayoutManager(2,6);
        mRvSingerList.setLayoutManager(horizontalPageLayoutManager);

        scrollHelper.setUpRecycleView(mRvSingerList);
        scrollHelper.setOnPageChangeListener(this);

        scrollHelper.scrollToPosition(0);

        mTvPrePage.setOnClickListener(this);
        mTvNextPage.setOnClickListener(this);
    }

    private void initData() {
        for (int i=0;i<30;i++) {
            SingerInfo data = new SingerInfo();
            data.artist = "鹿晗" + i;
            singerListAdapter.add(data);
        }
        singerListAdapter.notifyDataSetChanged();


        mRvSingerList.post(new Runnable() {
            @Override
            public void run() {
                mTvPage.setText("1/" + scrollHelper.getPageCount());
            }
        });

    }

    @Override
    public boolean handleBackEvent() {
        return false;
    }

    @Override
    public void freshFragData() {

    }


    @Override
    public void onPageChange(int index) {
        currentIndex = index;
        mTvPage.setText((index + 1) + "/" + scrollHelper.getPageCount());
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        SingerContentFragment singerContentFragment = (SingerContentFragment) getParentFragment();
        if (singerContentFragment != null) {
            singerContentFragment.switchFragment(SingerDetailFragment.newInstance());
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_pre_page:
                currentIndex--;
                if (currentIndex < 0) {
                    currentIndex = scrollHelper.getPageCount() - 1;
                }
                scrollHelper.scrollToPosition(currentIndex);
                break;
            case R.id.tv_next_page:
                currentIndex++;
                if (currentIndex == scrollHelper.getPageCount()) {
                    currentIndex = 0;
                }
                scrollHelper.scrollToPosition(currentIndex);
                break;
        }
    }
}
