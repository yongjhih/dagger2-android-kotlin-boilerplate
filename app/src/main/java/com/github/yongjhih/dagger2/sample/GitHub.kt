package com.github.yongjhih.dagger2.sample

import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by andrew on 11/8/16.
 */

// @BaseUrl("https://api.github.com/");
interface GitHub {
    @GET("/users/{user}/repos")
    fun repos(@Path("user") user: String): Observable<List<Repo>>
}
