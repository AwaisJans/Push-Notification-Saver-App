package com.push.notification.saver.app.activities

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.push.notification.saver.app.R
import com.push.notification.saver.app.databinding.ActivityFirstScreenBinding
import com.push.notification.saver.app.db.NotificationDatabaseHelper
import com.push.notification.saver.app.services.AppConfig

//import com.push.notification.saver.app.services.MyForegroundService


class FirstScreen : AppCompatActivity() {

    private lateinit var b: ActivityFirstScreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityFirstScreenBinding.inflate(layoutInflater)
        setContentView(b.root)


        val db = NotificationDatabaseHelper(this)

        b.btnNotificationHistory.setOnClickListener {
            startActivity(Intent(this, NotificationHistoryScreen::class.java))
        }

        b.idNumber.text = db.getAllNotifications().size.toString()


        if (intent.extras != null) {
            for (key in intent.extras!!.keySet()) {

                if (key == AppConfig.NAME) {
                    b.tvTitle.text = intent.extras!!.getString(key)
                } else if (key == AppConfig.BODY) {
                    b.tvMsg.text = intent.extras!!.getString(key)
                } else {
                    // do nothing
                }
            }
        }




    }



}