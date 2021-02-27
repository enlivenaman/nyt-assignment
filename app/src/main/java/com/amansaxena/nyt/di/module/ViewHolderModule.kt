package com.amansaxena.nyt.di.module

import androidx.lifecycle.LifecycleRegistry
import com.amansaxena.nyt.di.ViewModelScope
import com.amansaxena.nyt.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}