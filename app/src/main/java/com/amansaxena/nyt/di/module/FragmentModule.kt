package com.amansaxena.nyt.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.amansaxena.nyt.data.repository.NytApiRepository
import com.amansaxena.nyt.ui.base.BaseFragment
import com.amansaxena.nyt.util.ViewModelProviderFactory
import com.amansaxena.nyt.util.network.NetworkHelper
import com.amansaxena.nyt.util.rx.SchedulerProvider
import com.amansaxena.nyt.viewmodel.AppViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)

    @Provides
    fun provideDummiesViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        nytApiRepository: NytApiRepository
    ): AppViewModel =
        ViewModelProviders.of(fragment,
            ViewModelProviderFactory(AppViewModel::class) {
                AppViewModel(schedulerProvider, compositeDisposable, networkHelper, nytApiRepository)
            }
        ).get(AppViewModel::class.java)

    // provide adapters here id needed
    // fun provideDummiesAdapter() = DummiesAdapter(fragment.lifecycle, ArrayList())
}