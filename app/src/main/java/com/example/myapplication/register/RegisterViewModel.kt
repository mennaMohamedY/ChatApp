package com.example.myapplication.register

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.checkEmail
import com.example.myapplication.model.AppUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class RegisterViewModel:BaseViewModel() {

    val FstNameLiveData:MutableLiveData<String> = MutableLiveData()
    val Email:MutableLiveData<String> = MutableLiveData()
    val password:MutableLiveData<String> = MutableLiveData()
    val lstNameLiveData:MutableLiveData<String> = MutableLiveData()

    val emailError:MutableLiveData<String?> = MutableLiveData(null)
    val passwordError:MutableLiveData<String?> = MutableLiveData(null)
    val fstNameError:MutableLiveData<String?> = MutableLiveData(null)
    val lstNameError:MutableLiveData<String?> = MutableLiveData(null)
    val auth=Firebase.auth

    fun onRegister(){
        if(isValid()){
            creatAccountFromFireBase()
            Log.e("fun on Register","fun on register is called")
        }
    }
    fun creatAccountFromFireBase(){
        auth.createUserWithEmailAndPassword(Email.value!!, password.value!!)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    val uid=task.result.user?.uid

                    // addUserToFireBase()
                    Log.e("creatAcountFromFireBAse","fun creatAcountFromFireBAse is called!")
                    Log.e("Firebase", "createAccountOnFirebase: Success ${user?.email}")
                    addUserToFireStore(uid!!)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.e("Firebase", "createUserWithEmail:failure", task.exception)
                    msgLiveData.value=task.exception?.message


                }
            }
    }
    fun addUserToFireStore(uid:String){

        FirebaseFirestore.getInstance().collection(AppUser.collection_name)
            .document(uid).set(AppUser(uid,FstNameLiveData.value,lstNameLiveData.value,Email.value))
            .addOnSuccessListener {

            }.addOnFailureListener {
                Log.e("Failure","Failed!")
                msgLiveData.value=it.message
            }

    }

   // fun addUserToFireBase(){
        // Firebasef

   // }

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