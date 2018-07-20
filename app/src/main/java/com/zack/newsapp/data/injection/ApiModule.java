package com.zack.newsapp.data.injection;

import com.zack.newsapp.BuildConfig;
import com.zack.newsapp.data.ApiService;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by zack on 7/20/18.
 */
@Module()
public class ApiModule {
    @Provides
    OkHttpClient providesOkHttpClient(){
        Interceptor authInterceptor = chain->{
            HttpUrl url = chain.request().url()
                    .newBuilder().
                    addQueryParameter("apiKey", BuildConfig.ApiKey)
                    .build();
            Request request = chain.request().newBuilder().url(url).build();
            return chain.proceed(request);

        };

        return new OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .build();
    }
    @Provides
    Retrofit providesRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/top-headlines")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
    }

    @Provides
    ApiService providesApiService(Retrofit retrofit){
        return  retrofit.create(ApiService.class);
    }

}
