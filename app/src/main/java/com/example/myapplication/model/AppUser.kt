package com.example.myapplication.model

data class AppUser(
    var id:String?=null,
    var firstName:String?=null,
    var lastName:String?=null,
    var email:String?=null
){
    companion object{
        val collection_name="users"
    }
}
