package com.victor.ktv;


import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.victor.ktv.data.MusicData;
import com.victor.ktv.dialog.AtmosphereDialog;
import com.victor.ktv.dialog.CtrlDialog;
import com.victor.ktv.dialog.SongsOrderedDialog;
import com.victor.ktv.dialog.VolAdjustmentDialog;
import com.victor.ktv.fragment.DrinkFragment;
import com.victor.ktv.fragment.EntertainmentFragment;
import com.victor.ktv.fragment.RechargeFragment;
import com.victor.ktv.fragment.RecommendFragment;
import com.victor.ktv.fragment.ServiceFragment;
import com.victor.ktv.fragment.SingFragment;
import com.victor.ktv.module.Player;
import com.victor.ktv.util.Constant;
import com.victor.ktv.util.DateUtil;
import com.victor.ktv.util.MainHandler;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,
        View.OnClickListener {

    @Bind(R.id.fl_main_container)
    FrameLayout mFlMainContainer;

    @Bind(R.id.rg_left_action)
    RadioGroup mRgLeftAction;

    @Bind(R.id.ll_search)
    LinearLayout mLlSearch;

    @Bind(R.id.tv_songs_ordered)
    TextView mTvSongsOrdered;

    @Bind(R.id.tv_vol_ajustment)
    TextView mTvVolAdjustment;

    @Bind(R.id.tv_ctrl)
    TextView mTvCtrl;

    @Bind(R.id.tv_atmosphere)
    TextView mTvAtmosphere;

    @Bind(R.id.tv_play_sing)
    TextView mTvPlaySing;

    @Bind(R.id.tv_song_name)
    TextView mTvSongName;

    @Bind(R.id.tv_time)
    TextView mTvTime;

    @Bind(R.id.pb_play_progress)
    ProgressBar mPbProgress;

    private Fragment currentFragment;
    private int fragAction;

    private Player mPlayer;
    private long duration = 0;

    @Override
    public void handleMainMessage(Message message) {
        switch (message.what) {
            case Player.PLAYER_PREPARING:
                break;
            case Player.PLAYER_BUFFERING_START:
                break;
            case Player.PLAYER_BUFFERING_END:
                break;
            case Player.PLAYER_PREPARED:
                if (mPlayer != null) {
                    duration = mPlayer.getDuration();
                }
                break;
            case Player.PLAYER_PROGRESS_INFO:
                setProgress();
                break;
            case Player.PLAYER_COMPLETE:
                break;
            case Player.PLAYER_SEEK_END:
                break;
            case Player.PLAYER_PLAYING:
                break;
            case Player.PLAYER_PAUSE:
                break;
            case Player.PLAYER_ERROR:
                break;
            case Constant.Msg.HIDE_PLAY_SETTING:
                break;
            case Constant.Msg.HIDE_PLAY_VIEW:
                break;
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    private void initialize () {
        mPlayer = new Player(new SurfaceView(this),MainHandler.get());

        mRgLeftAction.setOnCheckedChangeListener(this);
        mLlSearch.setOnClickListener(this);
        mTvSongsOrdered.setOnClickListener(this);
        mTvVolAdjustment.setOnClickListener(this);
        mTvCtrl.setOnClickListener(this);
        mTvAtmosphere.setOnClickListener(this);

        switchFragment(currentFragment, RecommendFragment.newInstance(0));

    }

    private void switchFragment(Fragment fromFragment, Fragment toFragment) {
        if (currentFragment != null) {
            if (currentFragment.getClass().getName() == toFragment.getClass().getName()) {
                if (fragAction != Constant.Action.SWITCH_SEACH_FRAG) {
                    return;
                }
            }
        }

        currentFragment = toFragment;

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.anim_fragment_enter, R.anim.anim_fragment_exit);
        if (toFragment.isAdded()) {
            ft.show(toFragment);
        } else {
            ft.add(R.id.fl_main_container, toFragment);
        }
        if (fromFragment != null) {
            ft.hide(fromFragment);
        }
        ft.commitAllowingStateLoss();
    }



    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_recommend:
                switchFragment(currentFragment, RecommendFragment.newInstance(fragAction));
                fragAction = 0;
                break;
            case R.id.rb_sing:
                switchFragment(currentFragment, SingFragment.newInstance());
                break;
            case R.id.rb_entertainment:
                switchFragment(currentFragment, EntertainmentFragment.newInstance());
                break;
            case R.id.rb_service:
                switchFragment(currentFragment, ServiceFragment.newInstance());
                break;
            case R.id.rb_drink:
                switchFragment(currentFragment, DrinkFragment.newInstance());
                break;
            case R.id.rb_recharge:
                switchFragment(currentFragment, RechargeFragment.newInstance());
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_search:
                switchSearchFragment();
                break;
            case R.id.tv_songs_ordered:
                SongsOrderedDialog songsOrderedDialog = new SongsOrderedDialog();
                songsOrderedDialog.show(getSupportFragmentManager(),"SongsOrderedDialog");
                break;
            case R.id.tv_vol_ajustment:
                VolAdjustmentDialog volAdjustmentDialog = new VolAdjustmentDialog();
                volAdjustmentDialog.show(getSupportFragmentManager(),"VolAdjustmentDialog");
                break;
            case R.id.tv_ctrl:
                CtrlDialog ctrlDialog = new CtrlDialog();
                ctrlDialog.show(getSupportFragmentManager(),"CtrlDialog");
                break;
            case R.id.tv_atmosphere:
                AtmosphereDialog atmosphereDialog = new AtmosphereDialog();
                atmosphereDialog.show(getSupportFragmentManager(),"AtmosphereDialog");
                break;
        }
    }

    public void switchFragment(Fragment toFragment) {
        if (currentFragment == null) return;
        if (currentFragment instanceof RecommendFragment) {
            RecommendFragment recommendFragment = (RecommendFragment) currentFragment;
            if (recommendFragment != null) {
                recommendFragment.switchFragment(toFragment);
            }
        } else {

        }
    }

    public void switchSongFragment() {
        fragAction = Constant.Action.SWITCH_SONG_LIST_FRAG;
        mRgLeftAction.check(R.id.rb_recommend);
    }

    public void switchHotFragment() {
        fragAction = Constant.Action.SWITCH_HOT_SONG_LIST_FRAG;
        mRgLeftAction.check(R.id.rb_recommend);
    }
    public void switchSingerFragment() {
        fragAction = Constant.Action.SWITCH_SINGER_FRAG;
        mRgLeftAction.check(R.id.rb_recommend);
    }
    public void switchSearchFragment() {
        if (fragAction == Constant.Action.SWITCH_SEACH_FRAG) return;
        fragAction = Constant.Action.SWITCH_SEACH_FRAG;
        mRgLeftAction.check(R.id.rb_recommend);

        switchFragment(currentFragment, RecommendFragment.newInstance(fragAction));
    }

    public void setFragAction (int action) {
        fragAction = action;
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (mPlayer != null) {
            mPlayer.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer = null;
        }
    }

    private void setProgress () {
        long currentPos = 0;
        if (mPlayer != null) {
            currentPos = mPlayer.getCurrentPosition();
        }

        mTvTime.setText(DateUtil.formatPlayTime(currentPos));

        if (currentPos > duration || duration <= 0) return;
        int progress = (int) (currentPos * 100 / duration);
        mPbProgress.setProgress(progress);
    }

    public void play(MusicData data) {
        if (data == null) return;
        mPlayer.playUrl(data.path,false);
        mTvPlaySing.setText(data.title);
        mTvSongName.setText(data.title);
    }


}
