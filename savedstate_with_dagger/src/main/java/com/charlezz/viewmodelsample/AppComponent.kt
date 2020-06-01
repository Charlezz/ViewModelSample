package com.charlezz.viewmodelsample

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class
    ])
interface AppComponent : AndroidInjector<App>{
    @Component.Factory
    interface Factory : AndroidInjector.Factory<App>
}