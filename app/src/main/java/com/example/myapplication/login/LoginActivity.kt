package com.example.myapplication.login

import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.home.HomeActivity
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.register.RegisterActivity
import com.google.firebase.FirebaseApp

class LoginActivity : BaseActivity<ActivityLoginBinding,LoginViewModel>(),Navigator {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)

        dataBinding.viewModel=this.viewModel
        viewModel.email?.observe(this){
            Log.e("DataBinding","email ${it}")
        }
        viewModel.emailError?.observe(this){
            dataBinding.emailTxtField.error=it
        }
        viewModel.passwordError.observe(this){
            dataBinding.passwordTxtField.error=it
        }
        dataBinding.createAccTxt.setOnClickListener{
            val intent= Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
        viewModel.msgLiveData.observe(this){
            showDialog(it,"ok",object :OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    dialog?.dismiss()
                }
            })
        }
        viewModel.navigator=this

    }

    override fun getLayoutID(): Int {
        return R.layout.activity_login
    }

    override fun initViewModel(): LoginViewModel {
        return ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun navigateToHomePage() {
        val intent=Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}