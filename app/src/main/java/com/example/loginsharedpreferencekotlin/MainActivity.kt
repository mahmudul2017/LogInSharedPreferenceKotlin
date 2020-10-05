package com.example.loginsharedpreferencekotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreference: SharedPreferences
    lateinit var name: String
    lateinit var password: String
    var isChecked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreference = getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        isChecked = sharedPreference.getBoolean("checkBox", false)

        if (isChecked) {
            val intent = Intent(this, DashBoardActivity::class.java)
            startActivity(intent)
            finish()
        }

        btn_login.setOnClickListener {
            name = et_name.text.toString()
            password = et_password.text.toString()
            val checked = checkbox_stay.isChecked

            val editor = sharedPreference.edit()
            editor.putString("USER_NAME", name)
            editor.putString("USER_PASSWORD", password)
            editor.putBoolean("CHECKBOX", checked)
            editor.apply()

            Toast.makeText(this, "User information saved...", Toast.LENGTH_LONG).show()
            val intent = Intent(this, DashBoardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
