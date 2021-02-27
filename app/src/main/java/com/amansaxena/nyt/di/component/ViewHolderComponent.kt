package com.amansaxena.nyt.di.component

import com.amansaxena.nyt.di.ViewModelScope
import com.amansaxena.nyt.di.module.ViewHolderModule
import com.amansaxena.nyt.viewmodel.AppViewModel
import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {

    fun inject(viewHolder: AppViewModel)
}