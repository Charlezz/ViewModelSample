package com.charlezz.savedstate

import android.util.Log
import android.view.View
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistry

class MainViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    var count = 0
    set(value) {
        savedStateHandle.set("count",value)
        field = value
    }

    init {
        savedStateHandle.get<Int>("count")?.run {
            count = this
        }
    }

}