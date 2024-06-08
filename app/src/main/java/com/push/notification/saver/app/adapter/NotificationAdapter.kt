package com.push.notification.saver.app.adapter

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.push.notification.saver.app.R
import com.push.notification.saver.app.databinding.ItemNotificationsBinding
import com.push.notification.saver.app.model.NotificationItem
import com.push.notification.saver.app.db.NotificationDatabaseHelper


class NotificationAdapter(private val notificationList: List<NotificationItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private lateinit var b: ItemNotificationsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        b = ItemNotificationsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotificationVH(b.root)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as NotificationVH
        val context = holder.itemView.context
        val notification = notificationList[position]

        val dbHelper = NotificationDatabaseHelper(context)

        holder.tvNotificationTitle.text = notification.title
        holder.tvNotificationBody.text = notification.body

        Glide.with(context).load(notification.imageUrl).placeholder(R.drawable.ic_launcher_foreground).skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.ivNotificationImage)

        holder.itemView.setOnClickListener {
            AlertDialog.Builder(context, R.style.myDialogBoxTheme)
                .setTitle("Open Launch URL")
                .setMessage("THis will open Launch URL")
                .setPositiveButton(
                    "OK"
                ) { dialog, whichButton ->

                    if(notification.launchUrl.isEmpty()){
                        Toast.makeText(context, "No Launch URL", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        val browserIntent =
                            Intent(Intent.ACTION_VIEW, Uri.parse(notification.launchUrl))
                        context.startActivity(browserIntent)
                    }
                }.show()
        }

        holder.ivNotificationDelete.setOnClickListener {
            AlertDialog.Builder(context, R.style.myDialogBoxTheme)
                .setTitle("Delete Notification")
                .setMessage("This will delete Notification")
                .setPositiveButton("Yes") { dialog, whichButton ->
                    dbHelper.deleteNotification(notification.title)
                    context as Activity
                    context.recreate()
                    Toast.makeText(context, "Notification Deleted", Toast.LENGTH_SHORT).show()
                }.setNegativeButton("No") { dialog, whichButton ->
                    dialog.cancel()
                }.show()

        }


    }

    override fun getItemCount() = notificationList.size

    inner class NotificationVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNotificationTitle = b.tvNotificationTitle
        val tvNotificationBody = b.tvNotificationBody
        val ivNotificationImage = b.ivNotificationImage
        val ivNotificationDelete = b.ivDeleteNotification
    }
}