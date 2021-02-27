package com.amansaxena.nyt.di.component

import com.amansaxena.nyt.di.FragmentScope
import com.amansaxena.nyt.di.module.FragmentModule
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {
}