package com.victor.ktv.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.victor.ktv.R;

/*
 * -----------------------------------------------------------------
 * Copyright (C) 2018-2028, by Victor, All rights reserved.
 * -----------------------------------------------------------------
 * File: AbsDialog.java
 * Author: Victor
 * Date: 2019/3/22 14:05
 * Description:
 * -----------------------------------------------------------------
 */

public abstract class AbsDialog extends Dialog implements IDialogRecycle {

    protected Context mContext;

    protected abstract int bindContentView();

    public AbsDialog(Context context) {
        this(context, R.style.BaseNoTitleDialog);
    }

    public AbsDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getContext();
        setContentView(bindContentView());
        //设置属性信息宽高或者动画
        Window window = getWindow();
        handleWindow(window);
        WindowManager.LayoutParams wlp = window.getAttributes();
        handleLayoutParams(wlp);
        window.setAttributes(wlp);
    }

    /**
     * 用于处理窗口的属性
     *
     * @param window
     */
    protected void handleWindow(Window window) {

    }

    public void handleLayoutParams(WindowManager.LayoutParams wlp) {

    }

}
