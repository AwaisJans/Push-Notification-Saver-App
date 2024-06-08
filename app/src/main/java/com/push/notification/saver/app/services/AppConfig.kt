package com.push.notification.saver.app.services

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.app.Service
import android.content.Context
import androidx.core.content.ContextCompat.getSystemService

class AppConfig {

    companion object {
        const val NAME = "name"
        const val BODY = "message"
        const val LAUNCH_URL = "launch_url"
        const val IMAGE = "image"



         fun isServiceRunning(context: Context,serviceClass: Class<out Service>): Boolean {
            val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            for (service in activityManager.getRunningServices(Int.MAX_VALUE)) {
                if (serviceClass.name == service.service.className) {
                    return true
                }
            }
            return false
        }



    }


}