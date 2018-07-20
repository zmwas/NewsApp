package com.zack.newsapp.presentation.injection;

import com.zack.newsapp.AppComponent;
import com.zack.newsapp.data.injection.ApiModule;
import com.zack.newsapp.presentation.NewsListFragment;

import dagger.Component;

/**
 * Created by zack on 7/20/18.
 */
@FragmentScoped
@Component(modules = {NewsPresenterModule.class} , dependencies = {AppComponent.class})
public interface NewsPresenterComponent {
    void inject(NewsListFragment fragment);
}
