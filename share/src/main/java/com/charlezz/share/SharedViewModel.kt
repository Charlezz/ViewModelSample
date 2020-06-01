package com.charlezz.share

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel(){
    val count = MutableLiveData<Int>().apply { value = 0 }
}