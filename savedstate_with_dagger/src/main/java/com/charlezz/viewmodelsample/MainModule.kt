package com.charlezz.viewmodelsample

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class MainModule{

    @Provides
    @ActivityScope
    fun provideViewModelProvider(activity:MainActivity, viewModelFactory:InjectingSavedStateViewModelFactory):ViewModelProvider{
        return ViewModelProvider(activity, viewModelFactory.create(activity))
    }

}