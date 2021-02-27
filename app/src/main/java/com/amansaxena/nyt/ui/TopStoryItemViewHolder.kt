package com.amansaxena.nyt.ui

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.amansaxena.nyt.R
import com.amansaxena.nyt.data.remote.response.TopStoryModel
import com.amansaxena.nyt.di.component.ViewHolderComponent
import com.amansaxena.nyt.ui.base.BaseItemViewHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_view_top_stories.view.*

class TopStoryItemViewHolder(parent: ViewGroup) :
    BaseItemViewHolder<TopStoryModel, TopStoryItemViewModel>(R.layout.item_view_top_stories, parent) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.name.observe(this, Observer {
            itemView.tv_head_line_dummy.text = it
        })

        viewModel.url.observe(this, Observer {
            Glide.with(itemView.context).load(it).into(itemView.iv_dummy)
        })
    }

    override fun setupView(view: View) {
        view.setOnClickListener {
            viewModel.onItemClick(adapterPosition)
        }
    }
}