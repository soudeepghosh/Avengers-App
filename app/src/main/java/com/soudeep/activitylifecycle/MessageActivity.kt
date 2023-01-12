package com.soudeep.activitylifecycle

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class MessageActivity : AppCompatActivity() {
    lateinit var txtMessage:TextView
    var message = "Custom Message"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        title = "Message"

        txtMessage = findViewById(R.id.txtMessage)
        message = intent.getStringExtra("message")!!
        txtMessage.text = message



    }
}