package com.charlezz.viewmodelsample

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindsMainActivity(): MainActivity
}