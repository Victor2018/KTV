package com.victor.ktv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.victor.ktv.R;
import com.victor.ktv.adapter.OrderedListAdapter;
import com.victor.ktv.data.MusicData;
import com.victor.ktv.util.HorizontalPageLayoutManager;
import com.victor.ktv.util.PagingItemDecoration;
import com.victor.ktv.widget.PagingScrollHelper;

import butterknife.Bind;

public class OrderedListFragment extends BaseFragment implements PagingScrollHelper.onPageChangeListener,
        AdapterView.OnItemClickListener, View.OnClickListener {

    @Bind(R.id.rv_song_list)
    RecyclerView mRvSongList;

    @Bind(R.id.tv_pre_page)
    TextView mTvPrePage;

    @Bind(R.id.tv_page)
    TextView mTvPage;

    @Bind(R.id.tv_next_page)
    TextView mTvNextPage;

    PagingScrollHelper scrollHelper = new PagingScrollHelper();

    private HorizontalPageLayoutManager horizontalPageLayoutManager;
    private PagingItemDecoration pagingItemDecoration;
    private OrderedListAdapter orderedListAdapter;
    private int currentIndex;

    public static OrderedListFragment newInstance () {
        OrderedListFragment fragment = new OrderedListFragment();
        Bundle bundle = new Bundle();
//        bundle.putInt(FOLLOW_USER_ID_KEY,followUserId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_order_list;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
        initData();
    }

    public void initialize () {

        orderedListAdapter = new OrderedListAdapter(getContext(),this);
        orderedListAdapter.setHeaderVisible(false);
        orderedListAdapter.setFooterVisible(false);

        mRvSongList.setAdapter(orderedListAdapter);

        horizontalPageLayoutManager = new HorizontalPageLayoutManager(4,1);
        pagingItemDecoration = new PagingItemDecoration(getContext(),horizontalPageLayoutManager);
        mRvSongList.setLayoutManager(horizontalPageLayoutManager);
        mRvSongList.addItemDecoration(pagingItemDecoration);

        scrollHelper.setUpRecycleView(mRvSongList);
        scrollHelper.setOnPageChangeListener(this);

        scrollHelper.scrollToPosition(0);

        mTvPrePage.setOnClickListener(this);
        mTvNextPage.setOnClickListener(this);
    }

    private void initData() {
        for (int i=0;i<10;i++) {
            MusicData data = new MusicData();
            data.title = "十年 HD" + i;
            data.artist = "陈奕迅" + i;
            orderedListAdapter.add(data);
        }
        orderedListAdapter.notifyDataSetChanged();


        mRvSongList.post(new Runnable() {
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
