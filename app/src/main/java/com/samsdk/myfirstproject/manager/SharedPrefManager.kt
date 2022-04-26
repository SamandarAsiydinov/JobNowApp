package com.samsdk.myfirstproject.manager

import android.content.Context

class SharedPrefManager(context: Context) {
    //The user is only visible when accessing the application 1 time. The rest of the time is not visible
    private val sharedPref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    fun isFinished(isFinished: Boolean) {
        val edit = sharedPref.edit()
        edit.putBoolean("isFinish", isFinished)
        edit.apply()
    }

    fun getFinished(): Boolean {
        return sharedPref.getBoolean("isFinish", false)
    }
}