package com.zack.newsapp.adapters;

import android.view.View;

import com.zack.newsapp.data.entities.NewsArticle;

/**
 * Created by zack on 7/20/18.
 */

public interface RecyclerClickListener {
    void OnItemClicked(int Position, NewsArticle article, View v);
}
