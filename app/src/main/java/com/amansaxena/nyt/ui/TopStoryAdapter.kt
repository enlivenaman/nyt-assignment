package com.amansaxena.nyt.ui

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.amansaxena.nyt.data.remote.response.TopStoryModel
import com.amansaxena.nyt.ui.base.BaseAdapter

class TopStoryAdapter(
    parentLifecycle: Lifecycle,
    private val topStories: ArrayList<TopStoryModel>
) : BaseAdapter<TopStoryModel, TopStoryItemViewHolder>(parentLifecycle, topStories) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TopStoryItemViewHolder(parent)
}