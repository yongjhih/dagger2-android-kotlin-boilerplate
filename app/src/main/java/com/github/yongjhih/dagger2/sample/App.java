package com.github.yongjhih.dagger2.sample;

import android.support.multidex.MultiDexApplication;

public class App extends MultiDexApplication {
    MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        AppModule appModule = new AppModule(this);
        GitHubModule gitHubModule = new GitHubModule("https://api.github.com/");

        mainComponent = DaggerMainComponent.builder()
                .appModule(appModule)
                .gitHubModule(gitHubModule)
                .build();
    }

    public MainComponent mainComponent() {
        return mainComponent;
    }
}
