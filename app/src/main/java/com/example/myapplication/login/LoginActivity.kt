package com.example.myapplication.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    lateinit var viewModel:LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_login)
        viewModel=ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.viewModel=this.viewModel
        viewModel.email?.observe(this){
            Log.e("DataBinding","email ${it}")
        }
        viewModel.emailError?.observe(this){
            binding.emailTxtField.error=it
        }
        viewModel.passwordError.observe(this){
            binding.passwordTxtField.error=it
        }
        binding.createAccTxt.setOnClickListener{
            val intent= Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}