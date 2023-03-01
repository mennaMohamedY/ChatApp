package com.example.myapplication.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.home.HomeActivity
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityRegisterBinding
import com.google.firebase.FirebaseApp

class RegisterActivity : BaseActivity<ActivityRegisterBinding,RegisterViewModel>(),Navigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)

        dataBinding.viewModel=this.viewModel

        viewModel.Email.observe(this){
            Log.e("dataBinding","Email${it}")
        }
        viewModel.emailError.observe(this){
            dataBinding.emailAddressTxtField.error=it
        }
        viewModel.passwordError.observe(this){
            dataBinding.passwordTxtField.error=it
        }
        viewModel.lstNameError.observe(this){
            dataBinding.LstNameEditText.error=it
        }
        viewModel.fstNameError.observe(this){
            dataBinding.fstNameEditText.error=it
        }
        dataBinding.registrationBtn.setOnClickListener{

        }
        viewModel.msgLiveData.observe(this){
            showDialog(it,"ok"
            ) { dialog, which -> dialog?.dismiss() }
        }
        viewModel.navigator=this
    }

    override fun getLayoutID(): Int {
        return R.layout.activity_register
    }

    override fun initViewModel(): RegisterViewModel {
        return ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    override fun navigateToHomePage() {
        val intent=Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}