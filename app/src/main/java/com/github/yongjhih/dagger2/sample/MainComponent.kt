package com.github.yongjhih.dagger2.sample

import javax.inject.Singleton

import dagger.Component

/**
 * Created by andrew on 11/8/16.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, GitHubModule::class))
interface MainComponent {
    fun inject(fragment: ReposFragment)
}