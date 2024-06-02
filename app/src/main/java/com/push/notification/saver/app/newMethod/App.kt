package com.push.notification.saver.app.newMethod

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.O

class App:Application() {


    companion object{
        const val FCM_CHANNEL_ID = "FCM_CHANNEL_ID"
    }

    override fun onCreate() {
        super.onCreate()

        if(SDK_INT >= O){
            val fcmChannel = NotificationChannel(FCM_CHANNEL_ID,"FCM_Channel",
                NotificationManager.IMPORTANCE_HIGH)
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(fcmChannel)
        }



    }


}