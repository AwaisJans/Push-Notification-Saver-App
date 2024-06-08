package com.push.notification.saver.app.services

import android.app.Activity
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.push.notification.saver.app.db.NotificationDatabaseHelper
import com.push.notification.saver.app.model.NotificationItem

class FCMServiceClass: FirebaseMessagingService() {


    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)


        if(message.notification != null){

            val title = message.notification!!.title
            val body = message.notification!!.body
            // saving values
            val db = NotificationDatabaseHelper(this)
            db.addNotification(NotificationItem(title!!, body!!, "", ""))
        }

    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

}