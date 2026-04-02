package com.victor.ktv.app;

import android.app.Application;

import java.util.List;


/**
 * Created by victor on 2017/9/26.
 */

public class App extends Application{
    private static App instance;
    public App() {
        instance = this;
    }

    public static App get() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


}
