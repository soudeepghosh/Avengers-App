package com.soudeep.activitylifecycle

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class LoginActivity : AppCompatActivity(){
    lateinit var etMobileNo:EditText
    lateinit var etPassword:EditText
    lateinit var btnLogin:AppCompatButton
    lateinit var txtForgotPass:TextView
    lateinit var txtRegister:TextView
    val validMobileNo = "7584924354"
    val validPassword = arrayOf("tony","steve","thanos","bruce","soudeep")

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        title = "Log In"
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name),
            MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        if(isLoggedIn){
            val intent = Intent(this@LoginActivity,AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

        etMobileNo = findViewById(R.id.etMobileNo)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPass = findViewById(R.id.txtForgotPass)
        txtRegister = findViewById(R.id.txtRegister)



        btnLogin.setOnClickListener{
            val mobileNo = etMobileNo.text.toString()
            val password = etPassword.text.toString()
            var nameOfAvenger = "Avenger"
            if(mobileNo==validMobileNo && validPassword.contains(password)){
                val intent = Intent(this@LoginActivity,AvengersActivity::class.java)
                startActivity(intent)
                savePreferences()
            /*if(mobileNo==validMobileNo){
                if (password==validPassword[0]){
                    nameOfAvenger = "The Iron Man"
                    startActivity(intent)
                    intent.putExtra("Name",nameOfAvenger)
                }
                else if (password==validPassword[1]){
                    nameOfAvenger = "The Captain America"
                    startActivity(intent)
                    intent.putExtra("Name",nameOfAvenger)
                }
                else if (password==validPassword[2]){
                    nameOfAvenger = "The Thanos"
                    startActivity(intent)
                    intent.putExtra("Name",nameOfAvenger)
                }
                else if (password==validPassword[3]){
                    nameOfAvenger = "The Hulk"
                    startActivity(intent)
                    intent.putExtra("Name",nameOfAvenger)
                }
                else if (password==validPassword[4]){
                    nameOfAvenger = "The Avenger"
                    startActivity(intent)
                    intent.putExtra("Name",nameOfAvenger)
                }*/

            }else{
                Toast.makeText(
                    this@LoginActivity,
                    "Wrong mobile number or password",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        txtRegister.setOnClickListener{
            val intent = Intent(this@LoginActivity,RegisterActivity::class.java)
            startActivity(intent)
        }
        txtForgotPass.setOnClickListener{
            val intent = Intent(this@LoginActivity,ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
    }


}