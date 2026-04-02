package com.victor.ktv.util;

/**
 * Created by victor on 2017/9/26.
 */

public class Constant {
    public static final boolean MODEL_DEBUG = true;
    public static final boolean MODEL_ONLINE = true;
    public static final int BUILD_CODE = 0;
    public static final String MA_DATA                           = "madata";
    public static final String INTENT_ACTION_KEY                 = "INTENT_ACTION_KEY";


    public static class Action {
        public static final int SWITCH_HOT_SONG_LIST_FRAG                      = 0x201;
        public static final int SWITCH_RECOMMEND_DETAIL_FRAG                      = 0x202;
        public static final int SWITCH_SONG_LIST_FRAG                      = 0x203;
        public static final int SWITCH_SINGER_FRAG                      = 0x204;
        public static final int SWITCH_SEACH_FRAG                      = 0x205;
    }
    public static class Msg {
        public static final int HIDE_PLAY_CTRL_VIEW                        = 0x1001;
        public static final int HIDE_PLAY_SETTING = 0x1001;
        public static final int HIDE_PLAY_VIEW = 0x1002;
        public static final int SEEK_TO_POSITION = 0x1003;
        public static final int SEARCH_MUSIC_COMPLETE = 0x1004;
        public static final int SEARCH_APP_COMPLETE = 0x1005;
        public static final int SEARCH_PHOTO_COMPLETE = 0x1006;
        public static final int SEARCH_VIDEO_COMPLETE = 0x1007;
    }

    /**
     * 动画类型
     */
    public class Anim {
        public static final int SHOW_SETTING = 1;
        public static final int HIDE_SETTING = 2;
        public static final int SHOW_PLAY_CTRL = 3;
        public static final int HIDE_PLAY_CTRL = 4;
        public static final int SHOW_PLAY_BAR = 5;
        public static final int HIDE_PLAY_BAR = 6;
    }

    public static class ProgramType {
        public static final int TYPE_SERIES = 1;//连续剧
        public static final int TYPE_MOVIE = 2;//电影
        public static final int TYPE_VARIETY = 3;//综艺
        public static final int TYPE_CHILDREN = 4;//少儿
    }

    public static class ScreenScale {
        public static final int SCALE_ORIGINAL = 0;
        public static final int SCALE_FULLSCREEN = 1;
    }
}
