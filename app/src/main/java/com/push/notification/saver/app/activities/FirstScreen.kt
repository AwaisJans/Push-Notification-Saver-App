package com.push.notification.saver.app.activities

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.push.notification.saver.app.databinding.ActivityFirstScreenBinding
import com.push.notification.saver.app.model.NotificationItem


class FirstScreen : AppCompatActivity() {

    private lateinit var b: ActivityFirstScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityFirstScreenBinding.inflate(layoutInflater)
        setContentView(b.root)


        b.btnNotificationHistory.setOnClickListener{
            startActivity(Intent(this,NotificationHistoryScreen::class.java))
        }

    }


}