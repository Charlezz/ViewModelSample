package com.charlezz.viewmodelsample

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule{
    @Binds
    @Singleton
    abstract fun bindsApplication(app:App): Application
}