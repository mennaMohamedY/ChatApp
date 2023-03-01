package com.example.myapplication.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.checkEmail
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel:BaseViewModel<Navigator>() {

    val email:MutableLiveData<String> = MutableLiveData()
    val password:MutableLiveData<String> = MutableLiveData()
    val emailError:MutableLiveData<String>? = MutableLiveData(null)
    val passwordError:MutableLiveData<String?> = MutableLiveData(null)
    val auth=Firebase.auth

    fun signIn(){
        if(ValidateInput()){
            authEmaiLAndPassword()


        }
    }
    fun authEmaiLAndPassword(){
        auth.signInWithEmailAndPassword(email.value!!, password.value!!)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.e("success", "signInWithEmail:success")
                    val user = auth.currentUser
                    navigator?.navigateToHomePage()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.e("Fail", "signInWithEmail:failure", task.exception)
                    msgLiveData.value=task.exception?.message
                }
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


