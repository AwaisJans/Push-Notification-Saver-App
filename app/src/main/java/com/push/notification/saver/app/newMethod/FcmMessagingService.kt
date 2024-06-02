package com.push.notification.saver.app.newMethod

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.remoteMessage
import com.push.notification.saver.app.R
import com.push.notification.saver.app.activities.FirstScreen
import com.push.notification.saver.app.newMethod.App.Companion.FCM_CHANNEL_ID
import com.push.notification.saver.app.services.AppConfig

class FcmMessagingService: FirebaseMessagingService() {


    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        if(message.notification != null){
            val title = message.notification!!.title+"Owais"
            val body = message.notification!!.body


            val jumpIntent = Intent(this,FirstScreen::class.java)
            jumpIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            jumpIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            jumpIntent.putExtra(AppConfig.NAME,title)
            jumpIntent.putExtra(AppConfig.BODY,body)

            val pendingIntent = PendingIntent.getActivity(this,1110,
                jumpIntent, PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)


            val notification = NotificationCompat.Builder(this,FCM_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(body)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setColor(Color.BLUE)
                .build()

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(101,notification)

        }

    }


    override fun onDeletedMessages() {
        super.onDeletedMessages()
    }


    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

}