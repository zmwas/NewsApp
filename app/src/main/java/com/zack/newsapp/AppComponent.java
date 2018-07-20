package com.zack.newsapp;

import android.app.Application;

import com.zack.newsapp.data.ApiService;
import com.zack.newsapp.data.injection.ApiModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by zack on 7/20/18.
 */
@Singleton
@Component(modules = {
        ApiModule.class,
        })
public interface AppComponent {
    ApiService apiService();

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(NewsApplication application);
        AppComponent build();
    }


}
