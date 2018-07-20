package com.zack.newsapp.presentation;

/**
 * Created by zack on 7/20/18.
 */

public interface Presenter<T extends View> {
    void attachView(T view);
}
