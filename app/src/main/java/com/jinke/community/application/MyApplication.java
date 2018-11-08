package com.jinke.community.application;

import android.app.Application;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
