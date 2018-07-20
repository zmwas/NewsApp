package com.zack.newsapp.data;

import com.squareup.moshi.Json;

public class Source {

    @Json(name = "id")
    public String id;
    @Json(name = "name")
    public String name;

}
