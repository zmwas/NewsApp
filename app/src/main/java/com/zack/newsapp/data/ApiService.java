package com.zack.newsapp.data;

import com.zack.newsapp.data.entities.NewsArticle;
import com.zack.newsapp.data.entities.NewsArticleResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by zack on 7/20/18.
 */

public interface ApiService {
    @GET("/v2/top-headlines/")
    Observable<NewsArticleResponse> articles();
}
