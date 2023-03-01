package com.example.myapplication.home

import android.util.Log
import com.example.myapplication.base.BaseViewModel

class HomeViewModel:BaseViewModel<Navigator>() {



    fun addRoom(){
        navigator?.NavigateToCreateNewRoom()
        Log.e("newRoom","click happened")
    }
}