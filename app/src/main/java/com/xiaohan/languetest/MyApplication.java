package com.xiaohan.languetest;

import android.app.Application;
import android.content.Context;

/**
 * Created by xiaohan on 2019/6/30
 * Describe:
 */
public class MyApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
