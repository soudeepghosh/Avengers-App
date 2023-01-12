package com.soudeep.activitylifecycle

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton

class AvengersActivity : AppCompatActivity() {
//    var titleName:String? = "The Avengers"
    lateinit var btnLogout:AppCompatButton
    lateinit var sharedPreferences:SharedPreferences
    lateinit var etMessage:EditText
    lateinit var btnSendMessage:AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avenger)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), MODE_PRIVATE)
      /*  if(intent!=null){
            titleName = intent.getStringExtra("Name")
        }*/
        title = "The Avengers"

        btnLogout = findViewById(R.id.btnLogout)
        etMessage = findViewById(R.id.etMessage)
        btnSendMessage = findViewById(R.id.btnSendMessage)

        btnLogout.setOnClickListener{
            val intent= Intent(this@AvengersActivity,LoginActivity::class.java)
            startActivity(intent)
            sharedPreferences.edit().clear().apply()
            finish()
        }
        btnSendMessage.setOnClickListener{
            val intent = Intent(this@AvengersActivity,MessageActivity::class.java)
            val message = etMessage.text.toString()
            intent.putExtra("message",message)
            startActivity(intent)
        }
    }
}