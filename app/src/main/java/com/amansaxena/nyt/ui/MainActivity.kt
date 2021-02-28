package com.amansaxena.nyt.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.amansaxena.nyt.R
import com.amansaxena.nyt.di.component.ActivityComponent
import com.amansaxena.nyt.ui.base.BaseActivity
import com.amansaxena.nyt.viewmodel.AppViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<AppViewModel>() {

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var adapter: TopStoryAdapter

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupObservers() {
        viewModel.getTopStories().observe(this, Observer {
            it?.run {
                adapter.appendData(this)
            }
        })
    }
    override fun setupView(savedInstanceState: Bundle?) {
        recycler_view.layoutManager = linearLayoutManager
        recycler_view.adapter = adapter
    }
}