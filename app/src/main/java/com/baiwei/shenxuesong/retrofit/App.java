package com.baiwei.shenxuesong.retrofit;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.ButterKnife;

/**
 * Created by 杨杰 on 2017/12/2.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ButterKnife.setDebug(BuildConfig.DEBUG);
        Fresco.initialize(this);
    }
}
