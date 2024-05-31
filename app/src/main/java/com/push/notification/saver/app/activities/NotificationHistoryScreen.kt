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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
import com.push.notification.saver.app.adapter.NotificationAdapter
import com.push.notification.saver.app.databinding.ActivityNotificationHistoryScreenBinding
import com.push.notification.saver.app.model.NotificationItem

class NotificationHistoryScreen : AppCompatActivity() {

    private lateinit var b: ActivityNotificationHistoryScreenBinding

    private lateinit var notificationRecyclerView: RecyclerView
    private lateinit var notificationAdapter: NotificationAdapter
    private val notificationList = mutableListOf<NotificationItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityNotificationHistoryScreenBinding.inflate(layoutInflater)
        setContentView(b.root)

        notificationRecyclerView = b.notificationRV
        notificationAdapter = NotificationAdapter(notificationList)
        notificationRecyclerView.adapter = notificationAdapter
        notificationRecyclerView.layoutManager = LinearLayoutManager(this)








    }

}