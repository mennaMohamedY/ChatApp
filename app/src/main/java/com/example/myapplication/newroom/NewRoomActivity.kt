package com.example.myapplication.newroom

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityNewRoomBinding
import com.example.myapplication.home.HomeActivity
import com.example.myapplication.spinneradapter.Adapter

class NewRoomActivity : BaseActivity<ActivityNewRoomBinding,NewRoomViewModel>(),Navigator{
    lateinit var spinnerAdapter:Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding.viewModel=this.viewModel
        spinnerAdapter=Adapter(viewModel.CategoriesList)
        dataBinding.Spinner.adapter=spinnerAdapter


    }

    override fun getLayoutID(): Int {
        return R.layout.activity_new_room
    }

    override fun initViewModel(): NewRoomViewModel {
        return ViewModelProvider(this).get(NewRoomViewModel::class.java)
    }


    override fun NavigateToHome() {
        val intent=Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }
}