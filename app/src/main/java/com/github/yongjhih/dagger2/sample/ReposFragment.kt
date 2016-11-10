package com.github.yongjhih.dagger2.sample

import android.content.Context
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.facebook.drawee.backends.pipeline.Fresco
import com.infstory.v7.widget.ListRecyclerAdapter
import com.trello.rxlifecycle.components.support.RxFragment

import javax.inject.Inject

import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * A fragment representing a list of Items.
 *
 *
 * Activities containing this fragment MUST implement the
 * interface.
 */
class ReposFragment : RxFragment() {

    val TAG = MainActivity::class.java.name

    // ListRecyclerAdapter<M, P>
    var mRepoAdapter: ListRecyclerAdapter<Repo, RepoListPresenter>? = null

    @Inject lateinit var gitHub: GitHub

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_repos, container, false) as RecyclerView

        Fresco.initialize(context)
        // Inject gitHub with Dagger2Injection?
        App.mainComponent.inject(this)
        // or manual inject gitHub
        //OkHttpClient.Builder client = new OkHttpClient.Builder();
        //client.cache(new Cache(getCacheDir(), 10 * 1024 * 1024));
        //gitHub = new Retrofit.Builder()
        //        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        //        .addConverterFactory(LoganSquareConverterFactory.create())
        //        .baseUrl("https://api.github.com/")
        //        .client(client.build())
        //        .build().create(GitHub.class);

        // TODO use regular MVP instead of simple presenter
        mRepoAdapter = ListRecyclerAdapter.create<Repo, RepoListPresenter>()
        // createPresenter with V
        mRepoAdapter!!.createPresenter { parent, viewType -> RepoListPresenter(LayoutInflater.from(context).inflate(R.layout.list_repo, parent, false)) }
        gitHub.repos("yongjhih").compose(bindToLifecycle<List<Repo>>()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe { repos ->
            // populate M with retrofit as repository
            mRepoAdapter!!.list.clear()
            mRepoAdapter!!.list.addAll(repos)
            mRepoAdapter!!.notifyDataSetChanged()
        }

        val context = view.context
        view.layoutManager = LinearLayoutManager(context)
        view.adapter = mRepoAdapter

        // TODO pull2refresh feature
        return view
    }
}

