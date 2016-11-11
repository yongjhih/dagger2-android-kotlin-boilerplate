package com.github.yongjhih.dagger2.sample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.infstory.v7.widget.ListRecyclerAdapter;
import com.trello.rxlifecycle.components.support.RxFragment;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import javax.inject.Inject;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the
 * interface.
 */
public class ReposFragment extends RxFragment {
    public static final String TAG = ReposFragment.class.getSimpleName();

    // ListRecyclerAdapter<M, P>
    private ListRecyclerAdapter<Repo, RepoListPresenter> mRepoAdapter;

    @Inject
    GitHub gitHub;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ReposFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        RecyclerView view = (RecyclerView) inflater.inflate(R.layout.fragment_repos, container, false);

        Fresco.initialize(getContext());
        // Inject gitHub with Dagger2Injection?
        ((App) getActivity().getApplicationContext()).mainComponent().inject(this);
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
        mRepoAdapter = ListRecyclerAdapter.create();
        // createPresenter with V
        mRepoAdapter.createPresenter((parent, viewType) -> {
            return new RepoListPresenter(LayoutInflater.from(getContext()).inflate(R.layout.list_repo, parent, false));
        });
        gitHub.repos("yongjhih")
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(repos -> {
                    // populate M with retrofit as repository
                    mRepoAdapter.getList().clear();
                    mRepoAdapter.getList().addAll(repos);
                    mRepoAdapter.notifyDataSetChanged();
                });

        Context context = view.getContext();
        view.setLayoutManager(new LinearLayoutManager(context));
        view.setAdapter(mRepoAdapter);

        // TODO pull2refresh feature
        return view;
    }
}
