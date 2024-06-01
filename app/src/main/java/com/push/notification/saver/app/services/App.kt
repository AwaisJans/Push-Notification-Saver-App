package com.push.notification.saver.app.services

import android.app.Application
import com.onesignal.OneSignal

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        OneSignal.initWithContext(this)
        OneSignal.setAppId(AppConfig.ONESIGNAL_APP_ID)
        OneSignal.setNotificationOpenedHandler(MyNotificationHandler(applicationContext))

    }
}