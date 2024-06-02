package com.push.notification.saver.app.services

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.push.notification.saver.app.db.NotificationDatabaseHelper
import com.push.notification.saver.app.model.NotificationItem

//class NotificationWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
//    override fun doWork(): Result {
//        val title = inputData.getString("title") ?: ""
//        val message = inputData.getString("message") ?: ""
//
//        val db = NotificationDatabaseHelper(applicationContext)
//        db.addNotification(NotificationItem(title,message,"",""))
//
//        return Result.success()
//    }
//}