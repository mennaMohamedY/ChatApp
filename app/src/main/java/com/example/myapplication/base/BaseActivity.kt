package com.example.myapplication.base

import android.content.DialogInterface
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.ContactsContract.Data
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.example.myapplication.R

abstract class BaseActivity<DataBinding: ViewDataBinding, VM:BaseViewModel<*>>:AppCompatActivity(){
    lateinit var dataBinding:DataBinding
    lateinit var viewModel:VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding=DataBindingUtil.setContentView(this, getLayoutID())
        viewModel=initViewModel()

    }
    abstract fun getLayoutID():Int
    abstract fun initViewModel():VM
    fun showDialog(message:String,
                   positiveBtnText:String?,
                   positiveBtnOnClickListener:DialogInterface.OnClickListener?
    ){
        val alertDialog=AlertDialog.Builder(this)
            .setMessage(message).setPositiveButton(positiveBtnText,positiveBtnOnClickListener)
        alertDialog.show()


    }

}
