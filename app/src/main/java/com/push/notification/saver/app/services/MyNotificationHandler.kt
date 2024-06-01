package com.push.notification.saver.app.services

import android.content.Context
import android.content.Intent
import com.onesignal.OSNotificationOpenedResult
import com.onesignal.OneSignal
import com.push.notification.saver.app.activities.NotificationHistoryScreen
import com.push.notification.saver.app.model.NotificationItem

class MyNotificationHandler(private val context : Context) : OneSignal.OSNotificationOpenedHandler {

   override fun notificationOpened(result: OSNotificationOpenedResult?) {
       if (result == null) return

       val dbHelper = NotificationDatabaseHelper(context)

       val title = result.notification.title ?: ""
       val body = result.notification.body ?: ""
       val launchURL = result.notification.launchURL ?: ""
       val imageURL = result.notification.bigPicture ?: ""

       dbHelper.addNotification(NotificationItem(title, body, launchURL, imageURL))

       val intent = Intent(context, NotificationHistoryScreen::class.java)
       intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_NEW_TASK
       context.startActivity(intent)
   }
}




