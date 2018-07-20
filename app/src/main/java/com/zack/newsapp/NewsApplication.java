package com.zack.newsapp;

import android.app.Application;

/**
 * Created by zack on 7/20/18.
 */

public class NewsApplication extends Application {

    public  AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().application(this).build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }


}
