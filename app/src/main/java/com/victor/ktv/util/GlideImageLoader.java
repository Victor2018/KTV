package com.victor.ktv.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.victor.ktv.widget.BannerLayout;

public class GlideImageLoader implements BannerLayout.ImageLoader {
    @Override
    public void displayImage(Context context, int path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }
}
