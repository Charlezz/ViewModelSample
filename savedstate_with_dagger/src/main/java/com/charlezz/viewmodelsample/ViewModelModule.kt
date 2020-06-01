package com.charlezz.viewmodelsample

import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.Multibinds

@AssistedModule
@Module(includes = [AssistedInject_ViewModelModule::class])
abstract class ViewModelModule{
    @Multibinds
    abstract fun bindsViewModels(): Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModel>

    @Multibinds
    abstract fun bindsAssistedViewModels(): Map<Class<out ViewModel>, @JvmSuppressWildcards AssistedSavedStateViewModelFactory<out ViewModel>>

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindsOtherViewModel(factory: MainViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>
}