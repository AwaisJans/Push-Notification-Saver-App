package com.push.notification.saver.app.services

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.push.notification.saver.app.R
import com.push.notification.saver.app.activities.FirstScreen

//class MyForegroundService : Service() {
//
//    override fun onCreate() {
//        super.onCreate()
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val channel = NotificationChannel(
//                "foreground_channel",
//                "Foreground Service",
//                NotificationManager.IMPORTANCE_DEFAULT
//            )
//            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//            manager.createNotificationChannel(channel)
//        }
//    }
//
//    @SuppressLint("ForegroundServiceType")
//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        val notification = createNotification()
//        startForeground(1, notification)
//
//        context = this
//
//        return START_NOT_STICKY
//    }
//
//    private fun createNotification(): Notification {
//        val intent = Intent(this, FirstScreen::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        intent.putExtra("1","one")
//        val pendingIntent = PendingIntent.getActivity(this, 2,
//            intent, PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)
//
//
//        return NotificationCompat.Builder(this, "foreground_channel")
//            .setContentTitle("App is running").setContentIntent(pendingIntent)
//            .setContentText("Processing notifications")
//            .setSmallIcon(R.drawable.ic_launcher_foreground)
//            .build()
//    }
//
//    override fun onBind(intent: Intent?): IBinder? {
//        return null
//    }
//
//    @SuppressLint("StaticFieldLeak")
//    companion object{
//        lateinit var context:Context
//    }
//
//}