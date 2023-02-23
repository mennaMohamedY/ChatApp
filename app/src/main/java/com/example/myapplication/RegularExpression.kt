package com.example.myapplication

import java.util.regex.Pattern

val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(

  //from 1 upto 256 char is the length of chars that can be written before the @ sympol
  "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
          "\\@" +
          "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
          "(" +
          "\\." +
          "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
          ")+"
)
fun checkEmail(email: String): Boolean {
  return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
}