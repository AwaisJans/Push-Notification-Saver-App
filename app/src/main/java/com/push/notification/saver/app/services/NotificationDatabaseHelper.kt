package com.push.notification.saver.app.services

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.push.notification.saver.app.model.NotificationItem


class NotificationDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "notifications.db"
        private const val DATABASE_VERSION = 2
        private const val TABLE_NAME = "notifications"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TITLE = "title"
        private const val COLUMN_BODY = "body"
        private const val COLUMN_IMAGE_URL = "image_url"
        private const val COLUMN_LAUNCH_URL = "launch_url"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE $TABLE_NAME ("
                + "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "$COLUMN_TITLE TEXT, "
                + "$COLUMN_BODY TEXT,  "
                + "$COLUMN_IMAGE_URL TEXT, "
                + "$COLUMN_LAUNCH_URL TEXT)"
                )
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addNotification(notification: NotificationItem): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_TITLE, notification.title)
            put(COLUMN_BODY, notification.body)
            put(COLUMN_IMAGE_URL, notification.imageUrl)
            put(COLUMN_LAUNCH_URL, notification.launchUrl)
        }
        return db.insert(TABLE_NAME, null, values)
    }

    fun getAllNotifications(): List<NotificationItem> {
        val notificationList = mutableListOf<NotificationItem>()
        val selectQuery = "SELECT * FROM $TABLE_NAME ORDER BY $COLUMN_ID DESC"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        cursor.use {
            if (it.moveToFirst()) {
                do {
                    val id = it.getLong(it.getColumnIndexOrThrow(COLUMN_ID))
                    val title = it.getString(it.getColumnIndexOrThrow(COLUMN_TITLE))
                    val body = it.getString(it.getColumnIndexOrThrow(COLUMN_BODY))
                    val launchUrl = it.getString(it.getColumnIndexOrThrow(COLUMN_LAUNCH_URL))
                    val imageUrl = it.getString(it.getColumnIndexOrThrow(COLUMN_IMAGE_URL))
                    notificationList.add(NotificationItem(title, body,launchUrl,imageUrl))
                } while (it.moveToNext())
            }
        }
        return notificationList
    }

    fun deleteNotification(notificationTitle: String) {
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "$COLUMN_TITLE=?", arrayOf(notificationTitle))
        db.close()
    }
}
