package com.github.yongjhih.dagger2.sample

import android.app.Application

import com.github.aurae.retrofit2.LoganSquareConverterFactory

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory

@Module(includes = arrayOf(AppModule::class))
class GitHubModule(private val mBaseUrl: String) {

    @Provides
    @Singleton
    fun provideHttpCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024
        val cache = Cache(application.cacheDir, cacheSize.toLong())
        return cache
    }

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache, interceptor: Interceptor?): OkHttpClient {
        val client = OkHttpClient.Builder()
        if (interceptor != null) client.addInterceptor(interceptor)
        client.cache(cache)
        return client.build()
    }

    @Provides
    @Singleton
    fun provideGitHub(okHttpClient: OkHttpClient): GitHub {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(LoganSquareConverterFactory.create())
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build()
                .create<GitHub>(GitHub::class.java)
    }
}
