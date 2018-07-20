package com.zack.newsapp.presentation.injection;

import com.zack.newsapp.data.ApiService;
import com.zack.newsapp.presentation.NewsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zack on 7/20/18.
 */
@Module()
public class NewsPresenterModule {
    @Provides @FragmentScoped
    NewsPresenter providesNewsPresenter(ApiService apiService){
        return new NewsPresenter(apiService);
    }
}
