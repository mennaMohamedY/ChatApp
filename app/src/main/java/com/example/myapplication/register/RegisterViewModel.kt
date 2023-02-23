package com.example.myapplication.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.checkEmail

class RegisterViewModel:ViewModel() {

    val FstNameLiveData:MutableLiveData<String> = MutableLiveData()
    val Email:MutableLiveData<String> = MutableLiveData()
    val password:MutableLiveData<String> = MutableLiveData()
    val Btn:MutableLiveData<String> = MutableLiveData()
    val lstNameLiveData:MutableLiveData<String> = MutableLiveData()

    val emailError:MutableLiveData<String?> = MutableLiveData(null)
    val passwordError:MutableLiveData<String?> = MutableLiveData(null)
    val fstNameError:MutableLiveData<String?> = MutableLiveData(null)
    val lstNameError:MutableLiveData<String?> = MutableLiveData(null)

    fun onRegister(){
        if(isValid()){

        }
    }

    fun isValid():Boolean{
        var valid=true
        if(Email.value.isNullOrBlank()){
            valid=false
            emailError.value="Please Insert Email"
        }else if(!checkEmail(Email.value!!)){
            valid=false
            emailError.value="Invalid Email!"
        }else{
            emailError.value=null
        }

        if(password.value.isNullOrBlank()){
            valid=false
            passwordError.value="password is required"
        }else if(password.value!!.length<6){
            valid=false
            passwordError.value="Password must be longer than 6 chars"
        }else{
            passwordError.value=null
        }
        if(FstNameLiveData.value.isNullOrBlank()){
            valid=false
            fstNameError.value="first name is required"
        }
        if(lstNameLiveData.value.isNullOrBlank()){
            valid=false
            lstNameError.value="Last Name is required"
        }
        return valid
    }


}