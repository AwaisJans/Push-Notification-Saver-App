package com.push.notification.saver.app.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf

//class MyBroadcastReceiver : BroadcastReceiver() {
//    override fun onReceive(context: Context, intent: Intent) {
//        val title = intent.getStringExtra("title") ?: ""
//        val message = intent.getStringExtra("message") ?: ""
//
//        val workData = workDataOf(
//            "title" to title,
//            "message" to message
//        )
//
//        val workRequest = OneTimeWorkRequestBuilder<NotificationWorker>()
//            .setInputData(workData)
//            .build()
//
//        WorkManager.getInstance(context).enqueue(workRequest)
//    }
//}