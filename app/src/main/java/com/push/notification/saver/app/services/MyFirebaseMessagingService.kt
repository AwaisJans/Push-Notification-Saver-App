package com.push.notification.saver.app.services

import android.app.NotificationChannel

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.push.notification.saver.app.R
import com.push.notification.saver.app.activities.FirstScreen
import com.push.notification.saver.app.db.NotificationDatabaseHelper
import com.push.notification.saver.app.model.NotificationItem

//class MyFirebaseMessagingService : FirebaseMessagingService() {
//
//
//    override fun onMessageReceived(remoteMessage: RemoteMessage) {
//        super.onMessageReceived(remoteMessage)
//        remoteMessage.notification?.let {
//            val title = it.title
//            val message = it.body
//
//            val intent1 = Intent(packageName)
//            intent1.putExtra(AppConfig.NAME, title)
//            intent1.putExtra(AppConfig.BODY, message)
//            val localBroadcastManager = LocalBroadcastManager.getInstance(this)
//            localBroadcastManager.sendBroadcast(intent1)
//
//
//        }
//    }
//}