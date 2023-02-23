package com.example.myapplication.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityRegisterBinding
import com.example.myapplication.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    lateinit var binding:ActivityRegisterBinding
    lateinit var viewModel:RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_register)
        viewModel=ViewModelProvider(this).get(RegisterViewModel::class.java)
        binding.viewModel=this.viewModel

        viewModel.Email.observe(this){
            Log.e("dataBinding","Email${it}")
        }
        viewModel.emailError.observe(this){
            binding.emailAddressTxtField.error=it
        }
        viewModel.passwordError.observe(this){
            binding.passwordTxtField.error=it
        }
        viewModel.lstNameError.observe(this){
            binding.LstNameEditText.error=it
        }
        viewModel.fstNameError.observe(this){
            binding.fstNameEditText.error=it
        }
        binding.registrationBtn.setOnClickListener{

        }
    }
}