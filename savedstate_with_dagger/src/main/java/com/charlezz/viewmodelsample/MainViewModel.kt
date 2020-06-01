package com.charlezz.viewmodelsample

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class MainViewModel @AssistedInject
constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var count = 0
        set(value) {
            savedStateHandle.set("count", value)
            field = value
        }

    init {
        savedStateHandle.get<Int>("count")?.run {
            count = this
        }
    }

    @AssistedInject.Factory
    interface Factory : AssistedSavedStateViewModelFactory<MainViewModel>

}