package com.paxcel.languagechangedemo;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

/*
Created by Himanshi on 23 August 2018
 */

public class App extends Application {

    private final String TAG = "App";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleManager.setLocale(this);
    }
}