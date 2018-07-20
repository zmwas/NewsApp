package com.zack.newsapp.presentation;

import com.zack.newsapp.data.entities.NewsArticle;

import java.util.List;

/**
 * Created by zack on 7/20/18.
 */

public interface NewsInterface extends View{
    void displayArticles(List<NewsArticle> articles);
}
