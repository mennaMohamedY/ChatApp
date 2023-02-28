package com.example.myapplication.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel(){
    val msgLiveData: MutableLiveData<String> = MutableLiveData()
    val showProgressBar:MutableLiveData<Boolean> = MutableLiveData()
}