package com.zack.newsapp.data.entities;

import java.util.List;

/**
 * Created by zack on 7/20/18.
 */

public class NewsArticleResponse {
    public String status;
    public int totalResults;
    public List<NewsArticle>articles;

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<NewsArticle> getArticles() {
        return articles;
    }
}
