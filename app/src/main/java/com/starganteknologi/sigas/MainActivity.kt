package com.starganteknologi.sigas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.starganteknologi.sigas.datamanager.User
import com.starganteknologi.sigas.datamanager.UserSharedDataManager
import com.starganteknologi.sigas.repository.LoginRepo
import com.starganteknologi.sigas.repository.NetworkRepo
import com.starganteknologi.sigas.service.LoginService
import com.starganteknologi.sigas.service.LoginView
import com.starganteknologi.sigas.service.NetworkService
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), LoginView {

    private val userSharedDataManager: UserSharedDataManager = UserSharedDataManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener{
            val tag = javaClass.simpleName
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            userSharedDataManager.saveUsername(email);
            userSharedDataManager.savePlainPassword(password);

            val user:User = userSharedDataManager.readUser()
            Log.i(tag," plain Password "+user.plainPassword)

            val loginService = LoginService.instance
            val networkService = NetworkService.instance
            val loginRepo = LoginRepo(this,loginService, networkService)
            loginRepo.login(email,password);
            Log.i(tag,"Login")
            Toast.makeText(this, email , Toast.LENGTH_SHORT).show()
        }



    }

    override fun onSuccessLogin(userId: Int?, jwtToken: String?, msg: String?) {

        val networkService = NetworkService.instance
        val networkRepo = NetworkRepo(this,networkService)

        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w("FirebaseInstanceId", "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val fcmToken = task.result?.token

                Log.d("FCM TOKEN", fcmToken)

                networkRepo.updateFcm(userId,jwtToken,fcmToken)
            })
        startActivity<DashboardActivity>()
        finish()
    }

    override fun onFailedLogin(msg: String?) {
        alert {
            title = "Information"
            message = "Login Failed"
        }.show()
    }
}