package com.zack.newsapp.presentation.injection;

import com.zack.newsapp.data.injection.ApiModule;
import com.zack.newsapp.presentation.MainActivity;

import dagger.Component;

/**
 * Created by zack on 7/20/18.
 */
@Component(modules = {ApiModule.class,NewsPresenterModule.class})
public interface NewsPresenterComponent {
    void inject(MainActivity mainActivity);
}
