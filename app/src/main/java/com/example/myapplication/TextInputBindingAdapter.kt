package com.example.myapplication

import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter("app:setTextError")
fun EditText.setTextError(error:String?){
    setError(error)
}