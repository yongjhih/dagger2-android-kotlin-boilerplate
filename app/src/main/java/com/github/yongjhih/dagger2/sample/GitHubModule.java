package com.github.yongjhih.dagger2.sample;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.aurae.retrofit2.LoganSquareConverterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

@Module(includes = AppModule.class)
public class GitHubModule {
    private final String mBaseUrl;

    public GitHubModule(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }

    @Provides
    @Singleton
    Cache provideHttpCache(@NonNull Application application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    Interceptor provideInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(@NonNull Cache cache, @Nullable Interceptor interceptor) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        if (interceptor != null) client.addInterceptor(interceptor);
        client.cache(cache);
        return client.build();
    }

    @Provides
    @Singleton
    GitHub provideGitHub(@NonNull OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(LoganSquareConverterFactory.create())
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build().create(GitHub.class);
    }
}
