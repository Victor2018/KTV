package com.victor.ktv.data;

import java.io.Serializable;

/**
 * @Author Victor
 * @Date Create on 2018/2/5 09:37.
 * @Describe
 */

public class RecommendBannerItem implements Serializable {
    public String productId;
    public String markUrl;
    public String icon;
    public String description;
    public String title;
    public String type;
    public String templateModel;
    public String url;
    public long duration;
    public int episodeTotal;
    public int sort;
    public int episodeUpdated;
    public String markPosition;
    public String resAssetId;
    public String poster;
    public int posterResId;
    public int playSort;

    public long playProgress;
    public boolean isHistory;
}
