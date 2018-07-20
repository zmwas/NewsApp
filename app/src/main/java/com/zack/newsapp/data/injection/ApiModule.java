package com.zack.newsapp.data.injection;

import com.squareup.moshi.Moshi;
import com.zack.newsapp.BuildConfig;
import com.zack.newsapp.data.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by zack on 7/20/18.
 */
@Module()
public class ApiModule {
    @Provides @Singleton
    OkHttpClient providesOkHttpClient(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Interceptor authInterceptor = chain->{
            HttpUrl url = chain.request().url()
                    .newBuilder().
                    addQueryParameter("apiKey", BuildConfig.ApiKey)
                    .addQueryParameter("country","us")
                    .build();
            Request request = chain.request().newBuilder().url(url).build();
            return chain.proceed(request);

        };

        return new OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .addInterceptor(loggingInterceptor)
                .build();
    }
    @Provides @Singleton
    Retrofit providesRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
    }

    @Provides @Singleton
    ApiService providesApiService(Retrofit retrofit){
        return  retrofit.create(ApiService.class);
    }

}
