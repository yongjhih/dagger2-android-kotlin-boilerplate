package com.github.yongjhih.dagger2.sample;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by andrew on 11/8/16.
 */
@Singleton
@Component(modules = {AppModule.class, GitHubModule.class})
public interface MainComponent {
    void inject(ReposFragment fragment);
}