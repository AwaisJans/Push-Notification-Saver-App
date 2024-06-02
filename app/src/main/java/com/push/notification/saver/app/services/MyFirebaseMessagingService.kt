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

import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.google.firebase.database.FirebaseDatabase

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
=======
import com.push.notification.saver.app.model.NotificationItem

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val CHANNEL_ID = "fcm_default_channel"

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        // Handle the received message
        remoteMessage.notification?.let {
            val title = it.title ?: "FCM Message"
            val message = it.body ?: ""
            sendNotification(title, message)
//            saveNotification(title, message)
        }
    }

    private fun sendNotification(title: String, message: String) {
        val intent = Intent(this, FirstScreen::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)

        val notificationBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(message)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, "FCM Notifications", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)

            val database = FirebaseDatabase.getInstance().reference
            val notification = NotificationItem(title, message)
            database.child("notifications").push().setValue(notification)
                .addOnSuccessListener {
                    Log.d("FirebaseDB", "Notification saved successfully")
                }
                .addOnFailureListener {
                    Log.e("FirebaseDB", "Failed to save notification", it)
                }
        }

        notificationManager.notify(0, notificationBuilder.build())
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // Log and toast
        Log.d("FCMToken", token)
        // You can also send the token to your server or save it for future use
    }
}

