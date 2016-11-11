package com.github.yongjhih.dagger2.sample;

import android.support.annotation.NonNull;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by andrew on 11/8/16.
 */

// @BaseUrl("https://api.github.com/");
public interface GitHub {
    @GET("/users/{user}/repos")
    @NonNull Observable<List<Repo>> repos(@NonNull @Path("user") String user);
}
