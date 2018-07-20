package com.zack.newsapp.presentation;

import com.zack.newsapp.data.ApiService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zack on 7/20/18.
 */

public class NewsPresenter implements Presenter<NewsInterface> {
    private NewsInterface newsInterface;
    private ApiService apiService;
    private Disposable disposable;


    public NewsPresenter(ApiService apiService) {
        this.apiService = apiService;
    }

    public void onGetNewsArticles(){
        disposable = apiService.articles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(newsInterface::displayArticles);
    }

    @Override
    public void attachView(NewsInterface newsInterface) {
        this.newsInterface = newsInterface;
    }

    public void destroy(){
        if(!disposable.isDisposed()){
            disposable.dispose();
        }
    }
}
