package com.zack.newsapp.data.entities;

import com.squareup.moshi.Json;

public class NewsArticle {

    @Json(name = "source")
    public Source source;
    @Json(name = "author")
    public String author;
    @Json(name = "title")
    public String title;
    @Json(name = "description")
    public String description;
    @Json(name = "url")
    public String url;
    @Json(name = "urlToImage")
    public String urlToImage;
    @Json(name = "publishedAt")
    public String publishedAt;

    public Source getSource() {
        return source;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }
}