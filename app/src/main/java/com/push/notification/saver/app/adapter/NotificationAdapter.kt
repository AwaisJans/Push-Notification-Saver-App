package com.push.notification.saver.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.push.notification.saver.app.R
import com.push.notification.saver.app.model.NotificationItem

class NotificationAdapter(private val notificationList: List<NotificationItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_notifications, parent, false)
        return NotificationVH(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as NotificationVH
        val notification = notificationList[position]
        holder.title.text = notification.title
        holder.message.text = notification.message
    }

    override fun getItemCount() = notificationList.size

    class NotificationVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.notificationTitle)
        val message: TextView = itemView.findViewById(R.id.notificationMessage)
    }
}