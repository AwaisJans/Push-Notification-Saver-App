package com.push.notification.saver.app.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.messaging.FirebaseMessaging
import com.push.notification.saver.app.databinding.ActivityFirstScreenBinding
import com.push.notification.saver.app.db.NotificationDatabaseHelper
import java.util.Timer
import java.util.TimerTask




class FirstScreen : AppCompatActivity() {

    private lateinit var b: ActivityFirstScreenBinding

    private lateinit var timer: Timer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityFirstScreenBinding.inflate(layoutInflater)
        setContentView(b.root)

        val db = NotificationDatabaseHelper(this)
        b.btnNotificationHistory.setOnClickListener {
            startActivity(Intent(this, NotificationHistoryScreen::class.java))
        }



        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val token = task.result
                // get token for your registered device
                Log.d("task123",token)

            } else {
                println("Failed to get FCM token")
            }
        }




        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    b.idNumber.text = db.getAllNotifications().size.toString()
                }
            }
        }, 0, 1000) // Update every 1000 milliseconds (1 second)





    }

}