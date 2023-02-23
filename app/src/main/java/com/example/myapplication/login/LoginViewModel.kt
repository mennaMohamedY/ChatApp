package com.example.myapplication.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.checkEmail

class LoginViewModel:ViewModel() {

    val email:MutableLiveData<String> = MutableLiveData()
    val password:MutableLiveData<String> = MutableLiveData()
    val emailError:MutableLiveData<String>? = MutableLiveData(null)
    val passwordError:MutableLiveData<String?> = MutableLiveData(null)

    fun signIn(){
        if(ValidateInput()){

        }
    }

    fun ValidateInput():Boolean{
        var isValid=true
        if(email.value.isNullOrBlank()){
            //show error msg
            emailError?.value="Please Write Email!"
            isValid=false
        }else if(!checkEmail(email.value!!)){
            emailError?.value="InValid Email!"
            isValid=false
        }else{
            //3lshan yshel al error
            emailError?.value=null
        }

        if(password.value.isNullOrBlank()){
            isValid=false
            passwordError.value="Password Required"
        }else if (password.value!!.length <6){
            isValid=false
            passwordError.value="Password must be longer than 6 char"
        }else{
            passwordError.value=null
        }
            return isValid
    }

}


