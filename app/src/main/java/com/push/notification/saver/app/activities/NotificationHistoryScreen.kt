package com.push.notification.saver.app.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.push.notification.saver.app.adapter.NotificationAdapter
import com.push.notification.saver.app.databinding.ActivityNotificationHistoryScreenBinding
import com.push.notification.saver.app.db.NotificationDatabaseHelper


class NotificationHistoryScreen : AppCompatActivity() {

    private lateinit var b: ActivityNotificationHistoryScreenBinding

    private lateinit var notificationRecyclerView: RecyclerView
    private lateinit var notificationAdapter: NotificationAdapter

    @SuppressLint("SetTextI18n")
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


        b.ivBack.setOnClickListener{
            finish()
        }


    }

}