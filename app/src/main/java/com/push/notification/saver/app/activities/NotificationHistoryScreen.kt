package com.push.notification.saver.app.activities

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.push.notification.saver.app.adapter.NotificationAdapter
import com.push.notification.saver.app.databinding.ActivityNotificationHistoryScreenBinding
import com.push.notification.saver.app.db.NotificationDatabaseHelper
import com.push.notification.saver.app.model.NotificationItem
import java.util.Timer
import java.util.TimerTask

class NotificationHistoryScreen : AppCompatActivity() {

    private lateinit var b: ActivityNotificationHistoryScreenBinding

    private lateinit var notificationRecyclerView: RecyclerView
    private lateinit var notificationAdapter: NotificationAdapter
    private lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityNotificationHistoryScreenBinding.inflate(layoutInflater)
        setContentView(b.root)

        val dbHelper = NotificationDatabaseHelper(applicationContext)

        notificationRecyclerView = b.notificationRV
        notificationAdapter = NotificationAdapter(dbHelper.getAllNotifications())
        notificationRecyclerView.adapter = notificationAdapter
        notificationRecyclerView.layoutManager = LinearLayoutManager(this)


        if(dbHelper.getAllNotifications().isEmpty()){
            b.noNotification.visibility = android.view.View.VISIBLE

        }else{
            b.noNotification.visibility = android.view.View.GONE
        }


        timer = Timer()
        timer.schedule(object : TimerTask() {
            @SuppressLint("NotifyDataSetChanged")
            override fun run() {
                runOnUiThread {
                    notificationAdapter = NotificationAdapter(dbHelper.getAllNotifications())
                    notificationRecyclerView.adapter = notificationAdapter
                    notificationRecyclerView.layoutManager = LinearLayoutManager(this@NotificationHistoryScreen)
                }
            }
        }, 0, 1000) // Update every 1000 milliseconds (1 second)









        b.backBtn.setOnClickListener{
            finish()
        }






    }

}