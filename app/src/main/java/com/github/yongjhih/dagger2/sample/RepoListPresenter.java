package com.github.yongjhih.dagger2.sample;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.infstory.v7.widget.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoListPresenter extends Presenter<Repo> {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.image)
    DraweeView imageView;

    public RepoListPresenter(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void onBind(int position, @Nullable Repo repo) {
        if (repo == null) return;

        title.setText(repo.name);
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(ImageRequest.fromUri(Uri.parse(repo.owner.avatar_url))).setOldController(imageView.getController()).build();
        imageView.setController(draweeController);
    }
}
