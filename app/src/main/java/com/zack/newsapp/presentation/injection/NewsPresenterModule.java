package com.zack.newsapp.presentation.injection;

import com.zack.newsapp.data.ApiService;
import com.zack.newsapp.presentation.NewsPresenter;

import dagger.Module;

/**
 * Created by zack on 7/20/18.
 */
@Module()
public class NewsPresenterModule {

    NewsPresenter providesNewsPresenter(ApiService apiService){
        return new NewsPresenter(apiService);
    }
}
