package com.push.notification.saver.app.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.push.notification.saver.app.databinding.ActivityFirstScreenBinding
import com.push.notification.saver.app.services.NotificationDatabaseHelper


class FirstScreen : AppCompatActivity() {

    private lateinit var b: ActivityFirstScreenBinding


    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityFirstScreenBinding.inflate(layoutInflater)
        setContentView(b.root)


        b.btnNotificationHistory.setOnClickListener{
            startActivity(Intent(this,NotificationHistoryScreen::class.java))
        }


    }



}