package com.charlezz.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val TAG = "Charlezz"

    var count = 0

    init {
        Log.d(TAG, "ViewModel 생성")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel 종료")
    }
}