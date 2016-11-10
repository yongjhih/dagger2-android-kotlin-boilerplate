package com.github.yongjhih.dagger2.sample

import android.net.Uri
import android.view.View
import android.widget.TextView

import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.DraweeView
import com.facebook.imagepipeline.request.ImageRequest
import com.infstory.v7.widget.Presenter

import kotterknife.bindView

class RepoListPresenter(itemView: View) : Presenter<Repo>(itemView) {
    val title: TextView by bindView(R.id.title)
    val imageView: DraweeView<*> by bindView(R.id.image)

    override fun onBind(position: Int, repo: Repo?) {
        if (repo == null) return

        title.text = repo.name
        val draweeController = Fresco.newDraweeControllerBuilder().setImageRequest(ImageRequest.fromUri(Uri.parse(repo.owner!!.avatar_url))).setOldController(imageView.controller).build()
        imageView.controller = draweeController
    }
}
