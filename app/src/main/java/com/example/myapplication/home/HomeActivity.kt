package com.example.myapplication.home

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.newroom.NewRoomActivity

class HomeActivity : BaseActivity<ActivityHomeBinding,HomeViewModel>(),Navigator{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding.viewModel=this.viewModel
        viewModel.navigator=this
    }

    override fun getLayoutID(): Int {
        return R.layout.activity_home
    }

    override fun initViewModel(): HomeViewModel {
        return ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun NavigateToCreateNewRoom() {
        val intent=Intent(this,NewRoomActivity::class.java)
        startActivity(intent)
    }
}