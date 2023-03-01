package com.example.myapplication.newroom

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.spinneradapter.CategoryData
import java.util.Locale.Category

class NewRoomViewModel:BaseViewModel<Navigator>() {
    var RoomName:MutableLiveData<String> = MutableLiveData()
    var RoomDescrip:MutableLiveData<String> = MutableLiveData()
    val CategoriesList=CategoryData.getCategories()


    fun onCreateClick(){

    }

}