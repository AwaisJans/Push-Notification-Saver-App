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
import com.push.notification.saver.app.adapter.NotificationAdapter
import com.push.notification.saver.app.databinding.ActivityNotificationHistoryScreenBinding
import com.push.notification.saver.app.db.NotificationDatabaseHelper
import com.push.notification.saver.app.model.NotificationItem

class NotificationHistoryScreen : AppCompatActivity() {

    private lateinit var b: ActivityNotificationHistoryScreenBinding

    private lateinit var notificationRecyclerView: RecyclerView
    private lateinit var notificationAdapter: NotificationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityNotificationHistoryScreenBinding.inflate(layoutInflater)
        setContentView(b.root)


        val db = NotificationDatabaseHelper(this)


        notificationRecyclerView = b.notificationRV
        notificationAdapter = NotificationAdapter(db.getAllNotifications())
        notificationRecyclerView.adapter = notificationAdapter
        notificationRecyclerView.layoutManager = LinearLayoutManager(this)








    }

}