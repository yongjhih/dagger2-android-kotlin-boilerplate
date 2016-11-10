package com.github.yongjhih.dagger2.sample

import android.support.multidex.MultiDexApplication

class App : MultiDexApplication() {
    companion object {
        lateinit var mainComponent: MainComponent
    }
    override fun onCreate() {
        super.onCreate()

        mainComponent = DaggerMainComponent.builder()
                .appModule(AppModule(this))
                .gitHubModule(GitHubModule("https://api.github.com/"))
                .build()
    }

}
