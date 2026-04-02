package com.victor.ktv.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/*
 * -----------------------------------------------------------------
 * Copyright (C) 2018-2028, by Victor, All rights reserved.
 * -----------------------------------------------------------------
 * File: ImageUtil.java
 * Author: Victor
 * Date: 2019/9/19 13:49
 * Description:
 * -----------------------------------------------------------------
 */
public class ImageUtil {
    public static Bitmap getBitmapFormResources(Context context, int resId){
        if (context == null) return null;

        return BitmapFactory.decodeResource(context.getResources(),resId);
    }

    public static Drawable getDrawableFromResources(Context context, int resId){
        if (context == null) return null;

        return context.getResources().getDrawable(resId);
    }

    public static Drawable getDrawbleFormBitmap(Context context, Bitmap bitmap){
        if (context == null) return null;

        return new BitmapDrawable(context.getResources(),bitmap);
    }

    public static Bitmap getBitmapFormDrawable(Context context, Drawable drawable){
        if (context == null) return null;

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(),drawable.getOpacity()!= PixelFormat.OPAQUE
                        ? Bitmap.Config.ARGB_8888: Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        //设置绘画的边界，此处表示完整绘制
        drawable.draw(canvas);
        return bitmap;
    }
}
