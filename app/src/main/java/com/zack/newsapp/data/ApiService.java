package com.zack.newsapp.data;

import com.zack.newsapp.data.entities.NewsArticle;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by zack on 7/20/18.
 */

public interface ApiService {
    @GET("/top-headlines")
    Observable<List<NewsArticle>> articles();
}
