package com.example.loginsharedpreferencekotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashBoardActivity : AppCompatActivity() {

    lateinit var sharedPreference: SharedPreferences

    //  lateinit var name: String
    lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        sharedPreference = getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        val name = sharedPreference.getString("USER_NAME", "")
        tv_name.text = name
        password = sharedPreference.getString("USER_PASSWORD", "")!!
        tv_password.text = password

        btn_logout.setOnClickListener {
            val editor = sharedPreference.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
