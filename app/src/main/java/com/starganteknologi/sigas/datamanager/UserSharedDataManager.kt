package com.starganteknologi.sigas.datamanager

import android.content.Context
//import
//import androidx.core.content.Con
import androidx.preference.PreferenceManager

class UserSharedDataManager(private val context: Context) {
    fun saveUsername(username: String){
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context).edit()
        sharedPreferences.putString("username",username)
        sharedPreferences.apply()
    }
    fun savePlainPassword(plainPassword: String){
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context).edit()
        sharedPreferences.putString("plainPassword",plainPassword)
        sharedPreferences.apply()
    }
    fun saveJwtToken(jwtToken: String){
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context).edit()
        sharedPreferences.putString("jwtToken",jwtToken)
        sharedPreferences.apply()
    }
    fun saveFcmToken(fcmToken: String){
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context).edit()
        sharedPreferences.putString("fcmToken",fcmToken)
        sharedPreferences.apply()
    }


    fun saveUser(user: User){
        // 1
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context).edit()
        sharedPreferences.putInt("userID",user.id)
        sharedPreferences.putString("email",user.email)
        sharedPreferences.putStringSet("roles",user.roles?.toHashSet())
        sharedPreferences.putString("fullname",user.fullName)
        sharedPreferences.putString("displayName",user.displayName)
        sharedPreferences.putString("username",user.username)
        //sharedPreferences.putInt("role",user.role)
        sharedPreferences.putString("plainPassword",user.plainPassword)
        sharedPreferences.putString("jwtToken",user.jwtToken)
        sharedPreferences.putString("fcmToken",user.fcmToken)


        sharedPreferences.apply()
    }

    fun readUser():User {
        val defRoles:Set<String>? = setOf()
        // 1

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        // 2
        //val sharedPreferenceContents = sharedPreferences.all
        val userID = sharedPreferences.getInt("userID",0)
        val email = sharedPreferences.getString("email","")
        val roles = sharedPreferences.getStringSet("roles",defRoles)
        val fullName = sharedPreferences.getString("fullName","")
        val displayName = sharedPreferences.getString("displayName","")
        val username = sharedPreferences.getString("username","")
        val plainPassword = sharedPreferences.getString("plainPassword","")
        val fcmToken = sharedPreferences.getString("fcmToken","")
        val jwtToken = sharedPreferences.getString("jwtToken","")

        return User(id = userID,
            email = email,
            roles = roles?.toList(),
            fullName = fullName,
            displayName = displayName,
            username = username ,
            plainPassword = plainPassword,
            fcmToken = fcmToken,
            jwtToken = jwtToken
        )

    }
}