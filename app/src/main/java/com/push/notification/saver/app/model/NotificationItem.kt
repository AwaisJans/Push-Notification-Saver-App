package com.push.notification.saver.app.model

data class NotificationItem(
    val title: String,
    val body: String,
    val launchUrl: String,
    val imageUrl: String
)